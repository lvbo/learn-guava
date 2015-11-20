/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 类功能描述:
 * <ul>
 * <li><br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/2 15:55
 */
public class UserThread extends Thread {
    private Socket connection;
    private EventBus channel;
    private BufferedReader in;
    private PrintWriter out;

    public UserThread(Socket connection, EventBus channel) {
        this.connection = connection;
        this.channel = channel;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Subscribe
    public void recieveMessage(String message) {
        if (out != null) {
            out.println(message);
            System.out.println("recieveMessage:"+message);
        }
    }

    public void run() {
        try {
            String input;
            while ((input = in.readLine()) != null) {
                channel.post(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reached eof
        channel.unregister(this);
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        in = null;
        out = null;
    }

}
