/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.basic;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 类功能描述:
 * <ul>
 * <li><br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/9 16:58
 */
public class JoinerTest {

    /**
     * 使用Java类库做字符串连接,常见于SQL IN条件
     */
    public String buildString(List<String> stringList, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (String s : stringList) {
            if (s != null) {
                builder.append(s).append(delimiter);
            }
        }
        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }


    /**
     * 使用Guava的Joiner类后的效果
     */
    public String buildStringUseJoiner(List<String> stringList, String delimiter) {
        return Joiner.on(delimiter).skipNulls().join(stringList);
//        return Joiner.on(delimiter).useForNull("no value").join(stringList);
    }

    @Test
    public void testJoinerWorkWithStringBuilder() {
        List<Integer> mmList = new ArrayList<Integer>();
        mmList.add(1);
        mmList.add(2);
        mmList.add(9);
        mmList.add(null);
        Joiner joiner = Joiner.on(",").skipNulls();
        System.out.println(joiner.join(mmList));

        StringBuilder ddSB = new StringBuilder();
        ddSB.append("19").append(",");
        ddSB.append("40").append(",");
        System.out.println(joiner.appendTo(ddSB, mmList));
    }

    @Test
    public void testMapJoiner() {
        //Using LinkedHashMap so that the original order is preserved
        String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String,String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");
        String returnedString = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
        assertThat(returnedString, is(expectedString));
    }
}
