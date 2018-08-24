package Day_01.Test07;

import java.util.Calendar;

// 七、用程序判断2018年2月14日是星期几
public class Test07 {
    public static void main(String[] args) {
        Calendar cal=Calendar.getInstance();
        cal.set(2018,2,14);
        int i = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);
        String [] database={"","星期天","星期一","星期二","星期三",
                "星期四","星期五","星期六"};
        System.out.println("是"+database[i]);
    }

}
