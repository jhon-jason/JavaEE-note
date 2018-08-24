package Day_05.Test08;

public class Test08 {
    public static void main(String[] args) {
        Student jason = new Student("123", "jason", 100);
        Student jhon = new Student("345", "jhon", -100);
        System.out.println(jason);
        System.out.println(jhon);
    }
}
class NoSuchScoreExpection extends RuntimeException{
    public NoSuchScoreExpection() {
    }

    public NoSuchScoreExpection(String message) {
        super(message);
    }
}
class Student{
    private String num;
    private String name;
    private int score;

    public Student() {
    }

    public Student(String num, String name, int score) {
        this.num = num;
        this.name = name;
        setScore(score);
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
        if (score<0){
            throw new NoSuchScoreExpection("成绩不能为负数"+score);
        }
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}