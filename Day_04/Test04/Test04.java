package Day_04.Test04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Test04 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aaa",124);
        map.put("b",155);
        map.put("asf",1656);
        map.put("jb",16);
        map.put("ayt",14);
        map.put("fag",24);
        map.put("fa",684);
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
