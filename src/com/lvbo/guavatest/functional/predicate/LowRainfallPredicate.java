/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.functional.predicate;

import com.google.common.base.Predicate;
import com.lvbo.guavatest.functional.function.City;

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
 * @version 5.0 since 2014/9/10 14:07
 */
public class LowRainfallPredicate implements Predicate<City> {

    public boolean apply(City input) {
        return input.getAverageRainfall() < 45.7;
    }
}
