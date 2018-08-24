package Day_12.Test09;

import java.util.*;
import java.util.function.Supplier;

public class Test09 {
    public static void main(String[] args) {
        // 长度为5的String数组
        String[] obj = getObj(() -> {
            String[] arr = new String[5];
            return arr;
        });

        // 包含5个1-20的随机数的 Hashset<Integer>集合
        getObj(() -> {
            Set<Integer> set = new HashSet<>();
            Random r = new Random();
            for (int i = 0; i < 5; i++) {
                set.add(r.nextInt(20) + 1);
            }
            return set;
        });

        getObj(()->{
            Calendar cal = Calendar.getInstance();
            cal.set(2018,4,1);
            return cal;
        });

    }

    public static <T> T getObj(Supplier<T> s) {
        return s.get();
    }
}
