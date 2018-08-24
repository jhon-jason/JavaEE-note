package Day_05.Test11;

/*
 * 创建三个子线程，在每个线程中开启10万次的循环，
 * 线程1循环中将循环自增变量i赋值给Integer类型变量 a，
 * 线程2循环中将字符串"黑马程序员"赋值给String类型变量b,
 * 线程3循环中将字符串"黑马程序员"和循环自增变量i
 * 拼接后赋值给String类型变量c
 * 分别计算三个线程完成任务所用的毫秒值
 */
public class Test11 {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        MyThread1 th1 = new MyThread1();
        th1.start();
        long s2 = System.currentTimeMillis();
        MyThread2 th2 = new MyThread2();
        th2.start();
        long s3 = System.currentTimeMillis();
        MyThread3 th3 = new MyThread3();
        th3.start();
        long s4 = System.currentTimeMillis();
        System.out.println(s2-s1);
        System.out.println(s3-s2);
        System.out.println(s4-s3);
    }
}
class MyThread1 extends Thread{
    long s5 = System.currentTimeMillis();
    @Override
    public void run() {
        Integer a=0;
        for (int i = 0; i < 100000; i++) {
            a=i;
        }
        long s6 = System.currentTimeMillis();
        System.out.println("1---"+(s6-s5));
    }
}
class MyThread2 extends Thread{
    long s5 = System.currentTimeMillis();
    @Override
    public void run() {
        String b="";
        for (int i = 0; i < 100000; i++) {
            b="黑马程序员";
        }
        long s6 = System.currentTimeMillis();
        System.out.println("2---"+(s6-s5));
    }
}
class MyThread3 extends Thread{
    long s5 = System.currentTimeMillis();
    @Override
    public void run() {
        String c="";
        for (int i = 0; i < 100000; i++) {
            c=i+"黑马程序员";
        }
        long s6 = System.currentTimeMillis();
        System.out.println("3---"+(s6-s5));
    }
}
