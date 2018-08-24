package Day_02.Test05;

import java.util.ArrayList;

/*
*五、定义一个方法listTest(ArrayList<String> al, String s),
* 要求使用contains()方法判断al集合里面是否包含s
 */
public class Test05 {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("f");
        str.add("h");
        listTest(str,"b");
    }
    public static void listTest(ArrayList<String> al ,String s){
        if (al.contains(s)){
            System.out.println("包含"+s);
        }else{
            System.out.println("不包含"+s);
        }
    }
}
