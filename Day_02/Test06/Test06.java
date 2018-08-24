package Day_02.Test06;

import java.util.ArrayList;

/*
*六、定义一个方法listTest(ArrayList<String> al),
*  要求使用isEmpty()判断al里面是否有元素。
 */
public class Test06 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //list.add("f");
        ListTest(list);
    }
    public static void ListTest(ArrayList<String> al){
        if(al.isEmpty()){
            System.out.println("集合是空的");
        }else{
            System.out.println("集合是非空的");
        }
    }
}
