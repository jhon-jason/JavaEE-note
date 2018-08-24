package Day_02.Test09;

import java.util.ArrayList;

/*
*定义一个学生类Student，包含三个属性姓名、年龄、性别，
* 创建三个学生对象存入ArrayList集合中。
A：遍历集合遍历输出。
B：求出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。

 */
public class Test09 {
    public static void main(String[] args) {
        ArrayList<Student> stu= new ArrayList<>();
        stu.add(new Student("张三",17,"男"));
        stu.add(new Student("rose",18,"女"));
        stu.add(new Student("里斯",35,"男"));
        int maxAge=0;
        for (int i = 0; i < stu.size(); i++) {
            stu.get(i).show();
            maxAge=(maxAge>stu.get(i).getAge())?maxAge:stu.get(i).getAge();
        }
        for (int i = 0; i < stu.size(); i++){
            if (stu.get(i).getAge()==maxAge){
                stu.get(i).setName("小猪佩奇");
            }
        }
        for (int i = 0; i < stu.size(); i++) {
            stu.get(i).show();
            //System.out.println(stu.get(i).toString());
        }
    }
}

class Student{
    private String name;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void show(){
        System.out.println("姓名:"+name+"年龄:"+age+"性别:"+gender);
    }
}
