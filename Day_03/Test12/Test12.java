package Day_03.Test12;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

/*
 * 十二、双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 红色球号码从1—33中选择；蓝色球号码从1—16中选择；请随机生成一注双色球号码。
 * （要求同色号码不重复）
 */
/*

// 方案一
public class Test12 {
    public static void main(String[] args) {
        ArrayList<Integer> red = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 6;i++ ) {
            int nextNum = r.nextInt(33) + 1;
            if (red.contains(nextNum)) {
                i--;
                continue;
            } else {
                red.add(nextNum);
            }
        }
        int blue = r.nextInt(16) + 1;// 蓝球号码
        System.out.println(red+" "+blue);
    }
}
*/

//  方案二
public class Test12 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> red = new LinkedHashSet<>();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int nextNum = r.nextInt(33) + 1;
            if (!red.add(nextNum)) {
                i--;
            }
        }
        int blue = r.nextInt(16) + 1;// 蓝球号码
        System.out.println(red + " " + blue);
    }
}

