package Day_10.KZ01;

import java.io.Serializable;

/*
* 定义一个学生类，包含姓名，年龄，性别等成员变量，
* 提供setters和getters方法以及构造方法。
*/
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String age;
    private String gender;

    public Student() {
    }

    public Student(String name, String age, String gender) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
