/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.eventbus;

import com.google.common.eventbus.EventBus;
import org.junit.Test;


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
 * @version 5.0 since 2014/9/2 15:30
 */
public class TestEventBus {
    @Test
    public void testReceiveEvent() throws Exception {
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();
        eventBus.register(listener);
        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());
    }
}
