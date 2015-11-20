/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.basic;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Map;

/**
 * �๦������:
 * <ul>
 * <li><br>
 * </ul>
 * �޸ļ�¼��<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/9 17:24
 */
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
}
