package Day_02.Test10;

import java.util.ArrayList;
import java.util.Random;

/*
*十、产生10个1-100的随机数，并放到一个数组中，
* 把数组中大于等于10的数字放到一个list集合中，并打印到控制台
 */
public class Test10 {
    public static void main(String[] args) {
        Random r = new Random();
        int [] arr=new int [10];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr[i]=r.nextInt(100)+1;
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i]>10){
                list.add(arr[i]);
            }
        }
        System.out.println(list.toString());
    }
}
