package Day_05.Test10;

/*
 * 在一款角色扮演游戏中,每一个人都会有名字和生命值;角色的生命值不能为负数
 * 要求:当一个人物的生命值为负数的时候需要抛出自定的异常
 */
public class Test10 {
    public static void main(String[] args) {
    try {
        Role role = new Role("影魔", -1100);
        System.out.println(role);
    }
    catch(NoSushAgeException e){
        System.out.println(e);
        }

    }
}
class Role{
    private String name;
    private  int age;

    public Role() {
    }

    public Role(String name, int age) {
        this.name = name;
        setAge(age);
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

    public void setAge(int age) throws NoSushAgeException  {
        if (age<0){
            throw new NoSushAgeException("年龄小于0");
        }else
        this.age = age;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class NoSushAgeException extends RuntimeException{
    public NoSushAgeException(String message) {
        super(message);
    }
}
