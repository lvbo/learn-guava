package io.github.lvbo.learn.guava.files;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;

import java.io.IOException;
import java.util.List;

/**
 * Created by lvbo on 16/2/13.
 */
public class ToListLineProcessor implements LineProcessor<List<String>> {
    private static final Splitter splitter = Splitter.on(",");
    private List<String> bookTitles = Lists.newArrayList();
    private static final int TITLE_INDEX = 1;

    public List<String> getResult() {
        return bookTitles;
    }

    public boolean processLine(String line) throws IOException {
        bookTitles.add(Iterables.get(splitter.split(line), TITLE_INDEX));
        return true;
    }
}
