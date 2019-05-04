package io.github.lvbo.learn.guava.functional.predicate;

import com.google.common.base.Predicate;
import io.github.lvbo.learn.guava.functional.model.City;

public class PopulationPredicate implements Predicate<City> {

    public boolean apply(City input) {
        return input.getPopulation() <= 500000;
    }
}
