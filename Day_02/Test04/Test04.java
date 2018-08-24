package Day_02.Test04;

import java.util.ArrayList;
import java.util.Collection;

/*
*四、定义一个集合，并把集合(集合里面的元素是Integer)
* 转成存有相同元素的数组，并将结果输出在控制台。
* （可以使用Object[]数组类型接收转换的数组）
 */
public class Test04 {
    public static void main(String[] args) {
        Collection<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Object [] arr=list.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println("\b");
    }
}
