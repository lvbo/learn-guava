/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

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
 * @version 5.0 since 2014/9/2 11:13
 */
public class MultimapTest {

    @Test
    public void testArrayListMultiMap(){
        ArrayListMultimap<String,String> multiMap =
                ArrayListMultimap.create();
        multiMap.put("Foo","1");
        multiMap.put("Foo","2");
        multiMap.put("Foo","3");
        List<String> expected = Lists.newArrayList("1", "2", "3");
        assertEquals(multiMap.get("Foo"),expected);
    }

    @Test
    public void testArrayListMultimapSameKeyValue(){
        ArrayListMultimap<String,String> multiMap =
                ArrayListMultimap.create();
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        List<String> expected = Lists.
                newArrayList("1","2","3","3","3");
        assertEquals(multiMap.get("Bar"),expected);
    }

    @Test
    public void testHashMultimapKeyValue() {
        HashMultimap<String,String> multiMap =
                HashMultimap.create();
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        System.out.println(multiMap.get("Bar"));
    }

    @Test
    public void teststuScoreMultimap(){
        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create();
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        StudentScore studentScore1=new StudentScore();
        studentScore1.CourseId=1034;
        studentScore1.score=67;
        studentScore.add(studentScore1);

        StudentScore studentScore2=new StudentScore();
        studentScore2.CourseId=1045;
        studentScore2.score=56;
        scoreMultimap.put("jerry",studentScore2);

        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());


        for(StudentScore stuScore : scoreMultimap.values()) {
            System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
        }

        scoreMultimap.remove("jerry",studentScore2);
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("jerry"));

        scoreMultimap.put("harry",studentScore2);
        scoreMultimap.removeAll("harry");
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("harry"));
    }

    class StudentScore{
        int CourseId;
        int score;
    }
}
