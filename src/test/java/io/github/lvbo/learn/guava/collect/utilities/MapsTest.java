package io.github.lvbo.learn.guava.collect.utilities;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.lvbo.learn.guava.collect.model.Book;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsTest {

    @Test
    public void testListToMap() {
        List<Book> books = Lists.newArrayList();
        books.add(new Book("333"));
        books.add(new Book("444"));

        Map<String,Book> bookMap = new HashMap<String,Book>();
        for (Book book : books) {
            bookMap.put(book.getIsbn(),book);
        }
        System.out.println(bookMap);

        Map<String,Book> bookMap1 = Maps.uniqueIndex(books.iterator(), input -> {
                    assert input != null;
                    return input.getIsbn();
                }
        );
        System.out.println(bookMap1);
    }
}
