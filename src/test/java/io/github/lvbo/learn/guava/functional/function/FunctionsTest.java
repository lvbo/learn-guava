package io.github.lvbo.learn.guava.functional.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import io.github.lvbo.learn.guava.functional.model.City;
import io.github.lvbo.learn.guava.functional.model.State;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lvbo on 16/2/1.
 */
public class FunctionsTest {

    @Test
    public void test() {
        Map<String, State> stateMap = new HashMap<String, State>();

        State state1 = new State("tr", "89");
        Set<City> cities = new HashSet<City>();
        cities.add(new City("dd", "fff", 34));
        state1.setMainCities(cities);
        stateMap.put("aaaa", state1);

        State state2 = new State("tn", "9");
        Set<City> cities1 = new HashSet<City>();
        cities1.add(new City("d", "f", 3));
        cities1.add(new City("m", "f", 3));
        state2.setMainCities(cities1);
        stateMap.put("bbbb", state2);

        Function<String,State> lookup = Functions.forMap(stateMap);
        Function<State, String> stateFunction = new StateToCityStringFunction();
        Function<String,String> composed = Functions.compose(stateFunction, lookup);
        System.out.println(composed.apply("bbbb"));
        System.out.println(stateFunction.apply(lookup.apply("bbbb")));
    }

}
