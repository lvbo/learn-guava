package com.lvbo.guavatest.collect;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述：<br>
 * <ul>
 * <li><br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2015/11/10 15:47
 */
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

        Map<String,Book> bookMap1 = Maps.uniqueIndex(books.iterator(), new
                Function<Book, String>() {
                    public String apply(Book input) {
                        return input.getIsbn();
                    }
                }
        );
        System.out.println(bookMap1);
    }
}
