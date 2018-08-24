package Day_12.Test04;

public class Test04 {
    public static void main(String[] args) {
        int [] arr={1,2,4,9,6};
        getRandomNumFromOneToNum(5, new RandomUtil()::nextInt);
        getRandomNumFromAToB(5,10,new RandomUtil()::nextInt);
        getRandomNumFromArray(arr ,new RandomUtil()::nextInt);
    }
    static void getRandomNumFromOneToNum(int num , NumberSupplier ns){
        int num1 = ns.getNum(num);
        System.out.println(num1);
    }
    static void getRandomNumFromAToB(int a ,int b, NumberSupplier ns){
        int num1 = ns.getNum(a,b);
        System.out.println(num1);
    }
    static void getRandomNumFromArray(int[] nums, NumberSupplier ns){
        int num1 = ns.getNum(nums);
        System.out.println(num1);
    }
}

@FunctionalInterface
interface NumberSupplier{
    int getNum(int ... nums);
}
