package io.github.lvbo.learn.guava.functional.predicate;

import com.google.common.base.Predicate;
import io.github.lvbo.learn.guava.functional.model.City;
import io.github.lvbo.learn.guava.functional.model.Climate;

public class TemperateClimatePredicate implements Predicate<City> {

    public boolean apply(City input) {
        return input.getClimate().getCl() == Climate.TEMPERATE;
    }
}
