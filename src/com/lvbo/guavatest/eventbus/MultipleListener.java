/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.eventbus;

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
 * @version 5.0 since 2014/9/2 15:46
 */
public class MultipleListener {
    public Integer lastInteger;
    public Long lastLong;

    @Subscribe
    public void listenInteger(Integer event) {
        lastInteger = event;
        System.out.println("event Integer:"+lastInteger);
    }

    @Subscribe
    public void listenLong(Long event) {
        lastLong = event;
        System.out.println("event Long:"+lastLong);
    }

    public Integer getLastInteger() {
        return lastInteger;
    }

    public Long getLastLong() {
        return lastLong;
    }
}
