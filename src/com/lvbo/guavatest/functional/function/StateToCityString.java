/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.functional.function;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

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
 * @version 5.0 since 2014/9/10 11:09
 */
public class StateToCityString implements Function<State,String> {

    public String apply(State input) {
        return Joiner.on(",").join(input.getMainCities());
    }
}
