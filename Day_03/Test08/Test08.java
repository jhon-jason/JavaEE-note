package Day_03.Test08;

import java.util.Iterator;
import java.util.LinkedHashSet;

/*
* 八、使用LinkedHashSet存储以下元素：
* "王昭君","王昭君","西施","杨玉环","貂蝉"。
* 使用迭代器和增强for循环遍历LinkedHashSet
 */
public class Test08 {
    public static void main(String[] args) {
        LinkedHashSet<String>lin=new LinkedHashSet<>();
        lin.add("王昭君");
        lin.add("王昭君");
        lin.add("西施");
        lin.add("杨玉环");
        lin.add("貂蝉");
        Iterator<String> it = lin.iterator();
        while(it.hasNext()){
            //System.out.println(lin);
            System.out.println(it.next());
        }
        System.out.println("---------------");
        for (String s1:lin) {
            System.out.println(s1);
        }
    }
}
