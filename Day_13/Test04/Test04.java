package Day_13.Test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Test04 {
    public static void main(String[] args) {
//        ArrayList<String>list=new ArrayList<>();
//        String [] arr="黄药师，冯蘅，郭靖，黄蓉，郭芙，郭襄，郭破虏".split("，");
//        list.addAll(Arrays.asList(arr));
//        Iterator<String> it =list.stream().filter(s -> s.startsWith("郭")).iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        Stream<String> stream = Stream.of(("黄药师，冯蘅，" +
                "郭靖，黄蓉，郭芙，郭襄，郭破虏").split("，"));
        stream.filter(s->s.startsWith("郭")).forEach(System.out::println);
    }
}
