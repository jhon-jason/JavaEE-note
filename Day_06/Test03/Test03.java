package Day_06.Test03;

public class Test03 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread t=new MyThread();
        t.start();
        MyRun r=new MyRun();
        Thread t2=new Thread(r,"影魔");
        t2.start();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        String name = this.getName();
        System.out.println(name);
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRun implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}