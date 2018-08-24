package Day_12.Test11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Test11 {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("谢霆锋",85));
        arr.add(new Student("章子怡",63));
        arr.add(new Student("刘亦菲",77));
        arr.add(new Student("黄晓明",33));
        arr.add(new Student("岑小村",92));

        // 匿名内部类
        Collections.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore()-o2.getScore();
            }
        });


        // lambda
        Collections.sort(arr,(o1, o2) -> { return o1.getScore()-o2.getScore(); });

        // 方法引用

         Collections.sort(arr,Comparator.comparingInt(Student::getScore));


        System.out.println(arr);
    }
}
