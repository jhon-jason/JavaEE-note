package Day_07.Test10;

/*
// 标准格式
public class Test10 {
    public static void main(String[] args) {
        invokeCalc(
                10,20,(int c,int d)->{
                    return c-d;
                }
        );
    }
    private static void invokeCalc(int a,int b , Calculator c){
        int result=c.calc(a,b);
        System.out.println(result);
    }
}

interface Calculator{
    int calc(int a ,int b);
}

*/


// 省略格式
public class Test10 {
    public static void main(String[] args) {
        invokeCalc(10,20,(a,b)-> a-b);
    }
    private static void invokeCalc(int a,int b , Calculator c){
        int result=c.calc(a,b);
        System.out.println(result);
    }
}

interface Calculator{
    int calc(int a ,int b);
}