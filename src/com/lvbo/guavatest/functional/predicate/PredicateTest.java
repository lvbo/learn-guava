/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.functional.predicate;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.lvbo.guavatest.functional.model.City;
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
