/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.functional.function;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

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
 * @version 5.0 since 2014/9/10 11:09
 */
public class StateToCityString implements Function<State,String> {

    public String apply(State input) {
        return Joiner.on(",").join(input.getMainCities());
    }
}
