/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.HashBasedTable;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
 * @version 5.0 since 2014/9/2 14:00
 */
public class TableTest {

    @Test
    public void testTableOperation() {
        HashBasedTable<Integer,Integer,String> table = HashBasedTable.create();
        table.put(1,1,"Rook");
        table.put(1,2,"Knight");
        table.put(1,3,"Bishop");
        assertEquals(true, table.contains(1, 1));
        assertEquals(true, table.containsColumn(2));
        assertEquals(true, table.containsRow(1));
        assertEquals(true, table.containsValue("Rook"));
        table.remove(1,3);
        System.out.println(table.get(3, 4));
    }

}