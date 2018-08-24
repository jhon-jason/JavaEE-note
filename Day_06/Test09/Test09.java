package Day_06.Test09;

/*
 *  1.这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；
 *  2.随机生成10个人，同时准备过此山洞，
 *  并且定义一个变量用于记录通过隧道的人数。
 *  显示每次通过山洞人的姓名，和通过顺序；
 */
/*
public class Test09 {
    static int num = 1; // 定义记录通过隧道的人数
    public static void main(String[] args) {
        Object lock = new Object();
        Runnable runna = () -> {
            synchronized (lock) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 获取当前线程名称作为通过山洞的人员姓名
                String name = Thread.currentThread().getName();
                System.out.println(name + "-----" + num);
                num++;
            }
        };
        for (int j = 0; j < 10; j++) {
            new Thread(runna).start();
        }
    }
}

*/
public class Test09 {
    static int num=1;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try { cross(); } catch (InterruptedException e) { e.printStackTrace(); }
            }).start();
        }
    }
    public static synchronized void cross() throws InterruptedException {
        Thread.sleep(50);
        String name = Thread.currentThread().getName();
        System.out.println(name+"----"+num);
        num++;
    }
}

