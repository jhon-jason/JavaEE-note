
package Day_08.KuoZhan06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
从键盘接收一个文件夹路径,获得该文件夹大小并输出到控制台
 */
public class KuoZhan06 {
    static long fileTotleSize = 0;
    public static void main(String[] args) throws IOException {
        System.out.println("请输入路径");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        File f = new File(str);
        long l = get(f);
        System.out.println("此文件夹总大小为: " + l + "字节");
    }
    public static long get(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                fileTotleSize += file1.length();
            } else {
                get(file1);
            }
        }
        return fileTotleSize;
    }
}
