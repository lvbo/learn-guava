/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.basic;

import com.google.common.base.Ascii;
import org.junit.Test;

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
 * @version 5.0 since 2014/9/3 11:15
 */
public class AsciiTest {

    @Test
    public void testTruncate() {
        System.out.println(Ascii.truncate("who am i", 7, "...."));
    }
}
