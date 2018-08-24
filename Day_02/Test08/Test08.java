package Day_02.Test08;

import java.util.ArrayList;

/*
*八、定义一个方法listTest(ArrayList<Integer> al, Integer s)，
* 要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。
 */
public class Test08 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(6);
        int i = listTest(list, 3);
        if (i==-1){
            System.out.println("不存在");
        }else{
            System.out.println("索引位置是 "+i);
        }
    }
    public static int listTest(ArrayList<Integer> al,Integer s){
        return al.indexOf(s);
    }
}
