package Day_12.Test02;

public class Test02 {
    public static void main(String[] args) {
        getProduct(10,20,(a,b)->a*b);
    }
    public static void getProduct(int a ,int b, IntCalc i){
        int calc = i.calc(a, b);
        System.out.println(calc);
    }
}

@FunctionalInterface
interface IntCalc{
    int calc(int a ,int b);
}