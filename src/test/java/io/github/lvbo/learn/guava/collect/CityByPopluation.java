package io.github.lvbo.learn.guava.collect;

import com.google.common.primitives.Ints;
import io.github.lvbo.learn.guava.functional.model.City;

import java.util.Comparator;

public class CityByPopluation implements Comparator<City> {

    public int compare(City city1, City city2) {
        return Ints.compare(city1.getPopulation(), city2. getPopulation());
    }
}
