/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * �๦������:
 * <ul>
 * <li><br>
 * </ul>
 * �޸ļ�¼��<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/2 15:50
 */
public class DeadEventListener {
    boolean notDelivered = false;

    @Subscribe
    public void listen(DeadEvent event) {

        notDelivered = true;
    }

    public boolean isNotDelivered() {
        return notDelivered;
    }
}
