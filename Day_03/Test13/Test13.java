package Day_03.Test13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/*
* 十三、分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，
* 如果成绩一样，那在成绩排序的基础上按照年龄由小到大排序。
 */
//方案 一  实现 comparable
/*
public class Test13 {
    public static void main(String[] args) {
        ArrayList<Student> stu=new ArrayList<>();
        stu.add(new Student("lisi",22,90.0F));
        stu.add(new Student("liusan",20,90.0F));
        stu.add(new Student("jay",20,90.0F));
        stu.add(new Student("wangwu",20,99.0F));
        stu.add(new Student("sunliu",22,100.0F));
        stu.add(new Student("jack",22,10.0F));
        Collections.sort(stu);
        System.out.println(stu);
    }
}
class Student implements Comparable{
    private String name;
    private int age;
    private float score;

    public Student() {
    }

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}'+"\n";
    }

    @Override
    public int compareTo(Object o) {
        Student stu=(Student)o;
        if (this.score==stu.score){
            return this.age-stu.age;
        }
        return (int)(this.score-stu.score);
    }
}
*/

// 方案二
// 使用comparator
public class Test13 {
    public static void main(String[] args) {
        ArrayList<Student> stu=new ArrayList<>();
        stu.add(new Student("lisi",22,90.0F));
        stu.add(new Student("liusan",20,90.0F));
        stu.add(new Student("jay",20,90.0F));
        stu.add(new Student("wangwu",20,99.0F));
        stu.add(new Student("sunliu",22,100.0F));
        stu.add(new Student("jack",22,10.0F));
        Collections.sort(stu, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double i=(o1.getScore()-o2.getScore());
                if (i!=0){
                    return (int)i;
                }else
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(stu);
    }
}


class Student {
    private String name;
    private int age;
    private float score;

    public Student() {
    }

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}'+"\n";
    }

}

/*
// 测试三  当实现了 Comparable 然后调用comparator 比较
public class Test13 {
    public static void main(String[] args) {
        ArrayList<Student> stu=new ArrayList<>();
        stu.add(new Student("lisi",22,90.0F));
        stu.add(new Student("liusan",20,90.0F));
        stu.add(new Student("jay",20,90.0F));
        stu.add(new Student("wangwu",20,99.0F));
        stu.add(new Student("sunliu",22,100.0F));
        stu.add(new Student("jack",22,10.0F));
       // Collections.sort(stu);
        Collections.sort(stu, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double i=(o2.getScore()-o1.getScore());
                if (i!=0){
                    return (int)i;
                }else
                    return o2.getAge()-o1.getAge();
            }
        });
        System.out.println(stu);
    }
}
class Student implements Comparable{
    private String name;
    private int age;
    private float score;

    public Student() {
    }

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}'+"\n";
    }

    @Override
    public int compareTo(Object o) {
        Student stu=(Student)o;
        if (this.score==stu.score){
            return this.age-stu.age;
        }
        return (int)(this.score-stu.score);
    }
}
*/