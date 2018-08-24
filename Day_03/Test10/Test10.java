package Day_03.Test10;

import java.util.Iterator;
import java.util.LinkedList;

/*
* 十、已知数组存放一批QQ号码，QQ号码最长为11位，最短为5位
* String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}。
* 将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，
* 将list中所有元素分别用迭代器和增强for循环打印出来。
 */
public class Test10 {
    public static void main(String[] args) {
        String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
        LinkedList<String>lin=new LinkedList<>();
        for (String s1:strs) {
            if (!lin.contains(s1)) // 去除重复元素
            lin.add(s1);
        }
        Iterator<String> it = lin.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
