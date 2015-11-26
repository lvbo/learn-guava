/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.functional.predicate;

import com.google.common.base.Predicate;
import com.lvbo.guavatest.functional.model.City;

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
 * @version 5.0 since 2014/9/10 14:03
 */
public class TemperateClimatePredicate implements Predicate<City> {

    public boolean apply(City input) {
        return input.getClimate().getCl() == Climate.TEMPERATE;
    }
}
