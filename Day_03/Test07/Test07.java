package Day_03.Test07;

import java.util.ArrayList;

/*
* 七、向list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫。
 */
public class Test07 {
    public static void main(String[] args) {
       ArrayList<String> li=new ArrayList<>();
       li.add("张三");
       li.add("李四");
       li.add("王五");
       li.add("二丫");
       li.add("钱六");
       li.add("孙七");
       li.set(li.indexOf("二丫"),"王小丫");
        System.out.println(li);
    }
}
