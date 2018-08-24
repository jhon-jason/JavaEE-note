package Day_09.KuoZhan01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 在D盘下有一个文本文件test.txt(里面的内容由数字和字母组成)
 * 定义一个方法统计test.txt文件中’a’字符出现的次数。
 * 比如a字符在文件中出现了10次则调用方法传入a后，方法内部输出：a出现10次
 */
public class Kz01 {
    public static void main(String[] args) {
        byte[] b = new byte[1024 * 10];
        int len;
        LinkedList<String> list = new LinkedList<>();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\test.txt"))) {
            while ((len = bis.read(b)) != -1) {
                list.add(new String(b, 0, len));
            }
            String string = list.toString();
            countNum(string, 'a');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void countNum(String str, char target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target)
                count++;
        }
        System.out.println(target + "出现了 " + count + " 次");
    }
}
