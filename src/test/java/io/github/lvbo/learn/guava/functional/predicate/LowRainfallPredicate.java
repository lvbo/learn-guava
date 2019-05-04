package io.github.lvbo.learn.guava.functional.predicate;

import com.google.common.base.Predicate;
import io.github.lvbo.learn.guava.functional.model.City;

public class LowRainfallPredicate implements Predicate<City> {

    public boolean apply(City input) {
        return input.getAverageRainfall() < 45.7;
    }
}
