package Day_07.Test11;

import java.util.Arrays;

public class Test11 {
    public static void main(String[] args) {
        Student [] stu=new Student[3];
        stu [0]=new Student("影魔",100);
        stu [1]=new Student("屠夫",90);
        stu [2]=new Student("斧王",80);
        Arrays.sort(stu,(s1,s2)->{
            return s1.getScore()-s2.getScore();
        });
        for (Student student : stu) {
            System.out.println(student);
        }
    }
}

class Student{
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}