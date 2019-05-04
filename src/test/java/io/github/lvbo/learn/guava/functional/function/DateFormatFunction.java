package io.github.lvbo.learn.guava.functional.function;

import com.google.common.base.Function;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatFunction implements Function<Date, String> {

    public String apply(Date input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        return dateFormat.format(input);
     }
}
