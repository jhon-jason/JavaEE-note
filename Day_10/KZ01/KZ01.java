package Day_10.KZ01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
* 定义一个学生类，包含姓名，年龄，性别等成员变量，
* 提供setters和getters方法以及构造方法。
* 在测试类中创建一个学生对象，
* 给学生对象的三个成员变量赋值。然后将该对象保存到当前项目根目录下的stu.txt文件中。
 */
public class KZ01 {
    public static void main(String[] args) {
        Student stu = new Student("复仇之魂", "1000", "女");
        try(
        FileOutputStream fos = new FileOutputStream("stu.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){
            oos.writeObject(stu);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
