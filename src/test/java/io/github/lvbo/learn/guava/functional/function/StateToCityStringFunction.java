package io.github.lvbo.learn.guava.functional.function;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import io.github.lvbo.learn.guava.functional.model.State;

public class StateToCityStringFunction implements Function<State,String> {

    public String apply(State input) {
        return Joiner.on(",").join(input.getMainCities());
    }
}
