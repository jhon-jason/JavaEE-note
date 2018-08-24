package Day_09.KuoZhan02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
* 从控制台循环接收用户录入的学生信息，输入格式为：学号-学生名字
将学生信息保存到D盘下面的stu.txt文件中，一个学生信息占据一行数据。
当用户输入end时停止输入。
 */
public class Kz02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号-学生姓名,退出请输入\"end\"");
        String str = sc.next();
        while (!"end".equals(str)) {
            saveInfo(str);
            str = sc.next();
        }
        System.out.println("输入结束");
    }

    private static void saveInfo(String str) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\stu.txt", true))) {
            bw.write(str);
            bw.write("\r\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
