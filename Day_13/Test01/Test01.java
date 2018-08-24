package Day_13.Test01;

import java.util.function.Predicate;

public class Test01 {
    public static void main(String[] args) {
        Integer[] arr = {-12345, 9999, 520, 0, -38, -7758520, 941213};
        int count = 0, count2 = 0, count3 = 0;
        for (int i = 0; i < arr.length; i++) {
            // 自然数
            if (judge(arr[i], a -> a >= 0)) {
                count++;
            }
            // 绝对值大于100  && 偶数
            if (judge(arr[i], a -> Math.abs(a) > 100) && judge(arr[i], a -> a % 2 == 0)) {
                count2++;
            }
            if ((!judge(arr[i], a -> a >= 0)) || judge(arr[i], a -> a % 2 == 0)) {
                count3++;
            }
        }
        System.out.println("自然数个数: " + count);
        System.out.println("负整数的个数" + (arr.length - count));
        System.out.println("绝对值大于100的偶数" + count2);
        System.out.println("负整数或偶数的数的个数" + count3);
    }

    public static boolean judge(int a, Predicate<Integer> p) {
        return p.test(a);
    }
}
