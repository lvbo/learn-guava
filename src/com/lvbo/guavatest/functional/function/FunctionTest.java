/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.functional.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.Test;

import java.util.*;

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
 * @version 5.0 since 2014/9/10 11:11
 */
public class FunctionTest {

    @Test
    public void test1() {
        Map<String, State> stateMap = new HashMap<String, State>();

        State state1 = new State("tr", "89");
        Set<City> cities = new HashSet<City>();
        cities.add(new City("dd", "fff", 34));
        state1.setMainCities(cities);
        stateMap.put("aaaa", state1);

        State state2 = new State("tn", "9");
        Set<City> cities1 = new HashSet<City>();
        cities1.add(new City("d", "f", 3));
        state2.setMainCities(cities1);
        stateMap.put("bbbb", state2);

        Function<String,State> lookup = Functions.forMap(stateMap);
        Function<State, String> stateFunction = new StateToCityString();
        Function<String,String> composed = Functions.compose(stateFunction, lookup);
        System.out.println(composed.apply("aaaa"));
    }

    @Test
    public void test2() {
        System.out.print(new DateFormatFunction().apply(new Date()));
    }
}
