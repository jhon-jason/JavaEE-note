package Day_03.Test11;

import java.util.LinkedHashSet;
import java.util.Scanner;

/*
* 十一、键盘录入一个字符串，去掉其中重复字符，打印出不同的那些字符，
* 必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd
 */
public class Test11 {
    public static void main(String[] args) {
        deduplication();
    }
    // deduplication 去重
    public static void deduplication(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入:");
        String input=sc.next();
        LinkedHashSet<Character>lin=new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            lin.add(input.charAt(i));
        }
        System.out.println(lin);
    }
}
