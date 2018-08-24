package Day_02.Test07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
*
 */
public class Test07 {
    public static void main(String[] args) {
        Collection<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //Object [] arr=list.toArray();
        Iterator it=list.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+",");
        }
        System.out.println("\b");
    }
}
