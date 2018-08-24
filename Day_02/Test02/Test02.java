package Day_02.Test02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*public class Test02 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("a");
        System.out.println(listTest(list,"a"));
    }

    public static int listTest(Collection<String> list,String s) {
        int count=0;
        while (list.contains(s)){
            list.remove(s);
            count++;
        }
        return count;
    }
}*/

public class Test02 {
    public static void main(String[] args) {
        List<String> list1 =List.of("A","b","a");
        ArrayList<String>list=(ArrayList<String>) list1;
        System.out.println(listTest(list,"a"));
    }

    public static int listTest(ArrayList<String> list,String s) {
        int count=0;
        while (list.contains(s)){
            list.remove(s);
            count++;
        }
        return count;
    }
}

