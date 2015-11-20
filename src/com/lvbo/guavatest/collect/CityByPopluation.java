/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.primitives.Ints;
import com.lvbo.guavatest.functional.function.City;

import java.util.Comparator;

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
 * @version 5.0 since 2014/9/10 16:52
 */
public class CityByPopluation implements Comparator<City> {

    public int compare(City city1, City city2) {
        return Ints.compare(city1.getPopulation(), city2. getPopulation());
    }
}
