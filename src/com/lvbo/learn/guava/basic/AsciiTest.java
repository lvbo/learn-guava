/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.basic;

import com.google.common.base.Ascii;
import org.junit.Test;

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
 * @version 5.0 since 2014/9/3 11:15
 */
public class AsciiTest {

    @Test
    public void testTruncate() {
        System.out.println(Ascii.truncate("who am i", 7, "...."));
    }
}
