package Day_12.Test01;

public class Test01 {
    public static void main(String[] args) {
        showLongTime(()->{
            System.out.println(System.currentTimeMillis());
        });
    }
    public static void showLongTime(CurrentTimePrinter c){
        c.printCurrentTime();
    }
}

@FunctionalInterface
interface CurrentTimePrinter{
    void printCurrentTime();
}
