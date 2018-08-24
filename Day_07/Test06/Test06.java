package Day_07.Test06;

public class Test06 {
    public int start = 1;
    public int end = 99;

    public static void main(String[] args) {
        new Test06().method();
    }

    public void method() {
        Runnable r = (() -> {
            for (int i = start; i < end; i++) {
                System.out.println(i);
            }
        });
        new Thread(r).start();
    }
}
