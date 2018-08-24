package Day_13.Test02;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Test02 {
    public static void main(String[] args) {
        Map<String,Integer>map=new HashMap<>();
        map.put("岑小村",59);
        map.put("谷天洛",82);
        map.put("渣渣辉",98);
        map.put("蓝小月",65);
        map.put("皮几万",70);

        getAvg(map,map1->{
           // ArrayList<Integer>list=new ArrayList<>();
            int sum=0;
            Integer [] arr=new Integer [map1.size()];
            map1.values().toArray( arr);
            for (Integer integer : arr) {
                sum+=integer;
            }
            return sum/arr.length;
        });

    }
    public static void getAvg(Map<String,Integer> map,
                              Function<Map<String,Integer>,Integer> function){
        Integer apply = function.apply(map);
        System.out.println(apply);

    }
}
