package Day_12.Test08;

public class Test08 {
    public static void main(String[] args) {
        getIntegerArray(5,length -> new Integer[length]);
    }
    // 使用builder创建一个长度为length的Integer数组并打印其内存地址
    public static void getIntegerArray(int length , ArrayBuilder<Integer> builder){
        System.out.println(builder.buildArray(length));
    }
}

@FunctionalInterface
interface ArrayBuilder<T>{
     T[] buildArray(int length);
}
