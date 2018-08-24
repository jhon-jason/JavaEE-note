package Day_03.Test06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/*
 *六、定义人类，包含姓名和年龄属性。创建4个人存储到HashSet中，姓名和年龄相同的人看做同一人不存储
 */
public class Test06 {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("wang",28));
        set.add(new Person("zhang",28));
        set.add(new Person("wang",28));
//        Iterator<Person> it = set.iterator();
//        while(it.hasNext()){
//            it.next().show();
//        }
        for (Iterator<Person> it = set.iterator();it.hasNext();) {
            it.next().show();
        }
    }


}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void show() {
        System.out.println("姓名: " + name + " 年龄: " + age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(this.getClass() == obj.getClass()) || obj == null) {
            return false;
        }
        Person p1 = (Person) obj;
        return p1.age == this.age &&
                p1.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}