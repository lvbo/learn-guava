/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
 * @version 5.0 since 2014/9/10 15:55
 */
public class SetsTest {

    @Test
    public void test1() {
        Set<String> s1 = Sets.newHashSet("1","2","3");
        Set<String> s2 = Sets.newHashSet("2","3","4");
        Sets.SetView<String> dd = Sets.difference(s1, s2);
        System.out.println(dd);

        Sets.SetView setView = Sets.symmetricDifference(s1,s2);
        System.out.println(setView);

        Sets.SetView<String> sv = Sets.intersection(s1,s2);
        assertThat(sv.size()==2 && sv.contains("2") && sv.contains("3"),is(true));
    }

    @Test
    public void testUnion(){
        Set<String> s1 = Sets.newHashSet("1","2","3");
        Set<String> s2 = Sets.newHashSet("3","2","4");
        Sets.SetView<String> sv = Sets.union(s1,s2);
        assertThat(sv.size()==4 &&
                sv.contains("2") &&
                sv.contains("3") &&
                sv.contains("4") &&
                sv.contains("1"),is(true));
    }
}
