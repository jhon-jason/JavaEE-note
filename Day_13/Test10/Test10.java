package Day_13.Test10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test10 {
    public static void main(String[] args) {
        String [] world = ("《教父》,《肖申克的救赎》,《辛德勒的名单》,《公"+
                "民凯恩》,《卡萨布兰卡》,《教父续集》,《七武"+
                "士》,《星球大战》,《美国美人》,《飞跃疯人院》").split(",");
        String [] china = ("《霸王别姬》,《大闹天宫》,《鬼子来了》,《大话" +
                "西游》,《活着》,《饮食男女》,《无间" +
                "道》,《天书奇谭》,《哪吒脑海》,《春光乍泄》").split(",");
        Stream.of(world).limit(3).forEach(System.out::println);
        System.out.println("------------");
        Stream.of(china).limit(5).forEach(System.out::println);
        System.out.println("------------");



        Object[] objects = Stream.concat(Stream.of(world).limit(5), Stream.of(china).limit(5)).toArray();
        List<Object> list = Arrays.asList(objects);
        for (Object o : list) {
            System.out.println(o);
        }
        Stream<Film> stream = Stream.concat(Stream.of(world), Stream.of(china)).map(Film::new);
        List<Film> list1 = stream.collect(Collectors.toList());
        for (Film film : list1) {
            System.out.println(film);
        }

    }
}
class Film{
    private String name;

    public Film(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                '}';
    }
}