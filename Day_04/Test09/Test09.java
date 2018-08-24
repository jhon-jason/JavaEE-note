package Day_04.Test09;

import javax.swing.text.Keymap;
import java.util.*;

public class Test09 {
//    static{
//
//    }
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1930, "乌拉圭");
        map.put(1934, "意大利");
        map.put(1938, "意大利");
        map.put(1950, "乌拉圭");
        map.put(1954, "西德");
        map.put(1958, "巴西");
        map.put(1962, "巴西");
        map.put(1966, "英格兰");
        map.put(1970, "巴西");
        map.put(1974, "西德");
        map.put(1978, "阿根廷");
        map.put(1982, "意大利");
        map.put(1986, "阿根廷");
        map.put(1990, "西德");
        map.put(1994, "巴西");
        map.put(1998, "法国");
        map.put(2002, "巴西");
        map.put(2006, "意大利");
        map.put(2010, "西班牙");
        map.put(2014, "德国");
        Scanner sc = new Scanner(System.in);
        System.out.println("由年份查询 请输入 1 \n" +
                "由国家查询 请输入 2");
        int j = sc.nextInt();
        switch (j) {
            case 1:
                System.out.println("请输入一个年份 例如\"1987\"");
                int s = sc.nextInt();
                nianfen(s,map);
                break;
            case 2:
                System.out.println("请输入一个国家 例如\"巴西\"");
                String s2 = sc.next();
                guojia(s2,map);
                break;
        }
    }

    private static void guojia(String s2,HashMap<Integer, String> map) {
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        if (!map.containsValue(s2)){
            System.out.println(s2+"没有获得过世界杯");
        }
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            if(s2.equals(next.getValue())){
                System.out.println(next.getKey());
            }
        }
    }

    private static void nianfen(int s,HashMap<Integer, String> map) {
        String s1 = map.get(s);
        if (s1==null){
            System.out.println(s+"年未举行世界杯");

        }else
        System.out.println(s+"年的世界杯冠军是"+s1);
    }
}
