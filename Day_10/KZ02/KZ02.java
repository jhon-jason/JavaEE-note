package Day_10.KZ02;

import Day_10.KZ01.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class KZ02 {
    public static void main(String[] args) {
        Student stu = null;
        try(FileInputStream fis = new FileInputStream("stu.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Object o = ois.readObject();
            stu = (Student)o;
            System.out.println(stu.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
