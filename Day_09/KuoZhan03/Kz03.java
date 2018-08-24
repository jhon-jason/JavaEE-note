package Day_09.KuoZhan03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 从控制台接收3名学员的信息，每条信息存储到一个Student对象中，
 * 将多个Student对象存储到一个集合中。输入完毕后，将所有学员信息存储到文件Student.txt中。
 * 每名学员信息存储一行，多个属性值中间用逗号隔开。
 */
public class Kz03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入学生姓名,结束请输入\"end\"");
        String name, age, gender;
        LinkedList<Student> list = new LinkedList<>();
        //System.out.println("请输入学生姓名");
        while (!"end".equals(name = sc.next())) {
            System.out.println("请输入学生年龄");
            age = sc.next();
            System.out.println("请输入学生性别");
            gender = sc.next();
            System.out.println("请输入学生姓名,结束请输入\"end\"");
            list.add(new Student(name, age, gender));
        }
        System.out.println("输入完毕");
        saveInfor(list);

    }

    private static void saveInfor(LinkedList<Student> list) {
        for (Student student : list) {

            try (FileWriter fr = new FileWriter("E:\\student.txt", true)) {
                fr.write(student.getName());
                fr.write(",");
                fr.write(student.getAge());
                fr.write(",");
                fr.write(student.getGender());
                fr.write("\r\n");

                fr.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
