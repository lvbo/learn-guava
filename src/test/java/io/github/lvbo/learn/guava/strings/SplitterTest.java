package io.github.lvbo.learn.guava.strings;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SplitterTest {

    @Test
    public void test1() {
        Splitter splitter = Splitter.on("|").omitEmptyStrings().trimResults();
        String dd = "werweqr | asdfasd f | |||| asdfa sadf  | asdf | asd ";
        Iterable<String> ss = splitter.split(dd);
        for (String s : ss) {
            System.out.println(s);
        }
    }

    @Test
    public void testSplitter() {
        String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String,String> splitMap = mapSplitter.split(startString);
        System.out.println(splitMap);
    }

    @Test
    public void testA() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        try {
            Date date = formatter.parse("2023-12-2");
        System.out.println(date);
//            return sDate.equals(formatter.format(date));
//        } catch (Exception e) {
//            return false;
//        }
    }
}
