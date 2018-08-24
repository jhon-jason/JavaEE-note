package Day_06.Test06;

public class Test06 {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行");
                }
            }
        }).start();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            System.out.println("主线程执行");
        }
    }
}
