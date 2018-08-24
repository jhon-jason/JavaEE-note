package Day_13.Test05;

import java.util.ArrayList;
import java.util.Arrays;

public class Test05 {
    public static void main(String[] args) {
        String [] ar = ("陈玄风、梅超风、陆乘风、曲灵风、武眠风、冯默风、罗玉风").split("、") ;
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(ar));
        arr.stream().limit(2).forEach(System.out::println);
        System.out.println("-----------");
        arr.stream().skip(arr.size()-2).forEach(System.out::println);

    }
}
