package io.github.lvbo.learn.guava.functional.predicate;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.github.lvbo.learn.guava.functional.model.City;
import io.github.lvbo.learn.guava.functional.model.Climate;
import org.junit.Test;


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
