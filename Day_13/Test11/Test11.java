package Day_13.Test11;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test11 {
    public static void main(String[] args) {
        String [] arr=("河北省、山西省、吉林省、辽宁省、" +
                "黑龙江省、陕西省、甘肃省、青海省、山东省、福建省、" +
                "浙江省、台湾省、河南省、湖北省、湖南省、江西省、" +
                "江苏省、安徽省、广东省、海南省、四川省、贵州省、" +
                "云南省、北京市、天津市、上海市、重庆市、内蒙古自治区、" +
                "新疆维吾尔自治区、宁夏回族自治区、广西壮族自治区、西藏自治区、" +
                "香港特别行政区、澳门特别行政区").split("、");

        long count = Stream.of(arr).filter(s -> s.length() == 3).count();
        System.out.println("三个字的省份个数为: "+count);
        long count1 = Stream.of(arr).filter(s -> s.contains("东") || s.contains("西") ||
                s.contains("南") || s.contains("北")).count();
        System.out.println("名字中包含方位名词的省份: "+count1);
        long count2 = Stream.of(arr).filter(s -> (s.contains("东") || s.contains("西") ||
                s.contains("南") || s.contains("北"))&&!(s.contains("市")||
                s.contains("自治区")||s.contains("特别行政区"))).count();
        System.out.println(count2);
        Object[] array = Stream.of(arr).filter(s -> !s.contains("省")).toArray();
        System.out.println(Arrays.toString(array));
    }
}
