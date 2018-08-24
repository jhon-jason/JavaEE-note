package Day_09.Test07;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

// 请用户从控制台输入信息，程序将信息存储到文件Info.txt中。
// 可以输入多条信息，每条信息存储一行。当用户输入：”886”时，程序结束。
public class Test07 {
    public static void main(String[] args) {
        System.out.println("请输入信息,退出请输入\"886\"");
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        while (!"886".equals(str1)) {
            saveInfo(str1);
            str1 = sc.next();
        }
        System.out.println("输入结束");
    }

    public static void saveInfo(String str) {
        try (BufferedOutputStream bi = new BufferedOutputStream(
                new FileOutputStream("infor.txt", true))) {
            bi.write(str.getBytes());
            bi.write('\r');
            bi.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
