package Day_04.Test03;

import java.util.HashMap;

public class Test03 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("jay",1);
        map.put("esion",1);
        map.put("alin",2);
        map.put("hebe",3);
        System.out.println(map);
        map.remove("alin");
        System.out.println(map);
        System.out.println(map.get("jay"));

    }
}
