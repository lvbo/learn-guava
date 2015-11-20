/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.lvbo.guavatest.functional.function.City;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

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
 * @version 5.0 since 2014/9/10 16:54
 */
public class OrderingTest {

    @Test
    public void test1() {
        List<City> dd = Lists.newArrayList(new City("dd", "33", 34), new City("mm", "456", 23), new City("rr", "ee", 2));
        System.out.println(dd);
        Ordering<City> or = Ordering.from(new CityByPopluation());
        Collections.sort(dd, or);
        System.out.println(dd);
        Ordering<City> or1 = Ordering.from(new CityByPopluation()).reverse();
        Collections.sort(dd, or1);
        System.out.println(dd);
        dd.add(null);
        Ordering<City> or2 = Ordering.from(new CityByPopluation()).nullsFirst();
        Collections.sort(dd, or2);
        System.out.println(dd);
    }

    @Test
    public void test2() {
        List<City> dd = Lists.newArrayList(new City("dd", "33", 34), new City("mm", "456", 23), new City("rr", "ee", 2));
        System.out.println(dd);
        Ordering<City> or = Ordering.from(new CityByPopluation());
        List<City> top2 = or.greatestOf(dd, 2);
        System.out.println(top2);
    }
}
