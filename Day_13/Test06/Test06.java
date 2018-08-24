package Day_13.Test06;

/*
 * 有如下整数1，-2，-3，4，-5
 * 使用Stream取元素绝对值并打印
 */

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Test06 {
    public static void main(String[] args) {
        Stream.of("1，-2，-3，4，-5".split("，")).forEach(s -> {
            int abs = Math.abs(parseInt(s));
            System.out.println(abs);
        });


        Stream<Integer> stream = Stream.of(1, -2, -3, 4, -5);
        // 匿名内部类
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                int abs = Math.abs(s);
                System.out.println(abs);
            }
        });
        // Lambda 表达式 标准格式
//        stream.forEach((Integer s) -> {
//            int abs = Math.abs(s);
//            System.out.println(abs);
//        });
        // Lambda 表达式 省略格式
        Stream.of(1, -2, -3, 4, -5).forEach(s -> System.out.print(Math.abs(s)));
        // 方法引用
        Stream.of(1, -2, -3, 4, -5).forEach(Math::abs);

        Stream.of("one", "two", "three", "four") .filter(e -> e.length() > 3) .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase) .peek(e -> System.out.println("Mapped value: " + e)) .collect(Collectors.toList());
        System.out.println("+++++++++++++++");
        Stream.of("one", "two", "three", "four") .filter(e -> e.length() > 3) .peek(e -> System.out.println("Filtered value: " + e)) .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
