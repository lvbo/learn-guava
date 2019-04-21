/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.basic;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
 * @version 5.0 since 2014/9/1 16:36
 */
public class PreconditionsTest {
    @Test
    public void Preconditions() throws Exception {

        getPersonByPrecondition(8,"peida");

        try {
            getPersonByPrecondition(-9,"peida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Integer> intList=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            try {
                checkState(intList,9);
                intList.add(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        try {
            checkPositionIndex(intList,3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndex(intList,13);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndexes(intList,3,7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndexes(intList,3,17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositionIndexes(intList,13,17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkElementIndex(intList,6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkElementIndex(intList,16);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getPersonByPrecondition(int age,String neme)throws Exception{
        Preconditions.checkNotNull(neme, "nemeΪnull");
        Preconditions.checkArgument(neme.length()>0, "nemeΪ\'\'");
        Preconditions.checkArgument(age>0, "age �������0");
        System.out.println("a person age:"+age+",neme:"+neme);

    }

    public static void checkState(List<Integer> intList,int index)throws Exception{
        //���ʽΪtrue�����쳣
        Preconditions.checkState(intList.size()<index, " intList size ���ܴ���"+index);
    }

    public static void checkPositionIndex(List<Integer> intList,int index) throws Exception{
        Preconditions.checkPositionIndex(index, intList.size(), "index "+index+" ���� list�У� List sizeΪ��"+intList.size());
    }

    public static void checkPositionIndexes(List<Integer> intList,int start,int end) throws Exception{
        Preconditions.checkPositionIndexes(start, end, intList.size());
    }

    public static void checkElementIndex(List<Integer> intList,int index) throws Exception{
        Preconditions.checkElementIndex(index, intList.size(),"index Ϊ "+index+" ���� list�У� List sizeΪ�� "+intList.size());
    }

}
