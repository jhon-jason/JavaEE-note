package Day_04.Test08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 八、定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）
 * 出现的次数。例如：集合中有”abc”、”bcd”两个元素，
 * 程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
 */
public class Test08 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bcd");

        count(list);
    }

    public static  void count(List<String> list) {
        // map 集合key 为字符 value 为字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        // 遍历list 每个字符串的每个字符
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                Integer integer = map.get(s.charAt(j));
                // 如果为空 说明第一次出现,
                if (integer != null) {
                    map.put(s.charAt(j), integer + 1);
                } else {
                    map.put(s.charAt(j), 1);
                }
            }
        }
        System.out.println(map);
    }
}
