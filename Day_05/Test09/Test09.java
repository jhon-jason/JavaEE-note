package Day_05.Test09;
/*
* 创建多线程对象，开启多线程。在子线程中输出1-100之间的偶数，
* 主线程输出1-100之间的奇数
 */
public class Test09 {
    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(i%2==1?"奇数"+i:"");
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println(i%2==0?"偶数"+i:"");
        }
    }
}
