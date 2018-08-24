package Day_07.Test08;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Test08 {
    public static void main(String[] args) {
        ExecutorService pool = newFixedThreadPool(2);
        pool.submit(new Thread(
                () -> {
                    synchronized (pool) {
                        System.out.println("我需要一个老师");
                        try {
                            Thread.sleep(2000);
                            System.out.println("刘老师");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }));

        pool.submit(new Thread(
                () -> {
                    synchronized (pool) {

                        System.out.println("教我java,教完后，老师回到了办公室");
                    }
                }
        ));
    }
}
