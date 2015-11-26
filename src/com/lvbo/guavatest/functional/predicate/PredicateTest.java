/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.functional.predicate;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.lvbo.guavatest.functional.model.City;
import org.junit.Test;


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
 * @version 5.0 since 2014/9/10 14:10
 */
public class PredicateTest {

    @Test
    public void test1() {
        Predicate smallAndDry = Predicates.and(new LowRainfallPredicate(), new TemperateClimatePredicate());
        City city = new City("dd", "dd", 4);
        city.setAverageRainfall(45);
        Climate climate = new Climate();
        climate.setCl(34);
        city.setClimate(climate);
        System.out.print(smallAndDry.apply(city));
    }
}
