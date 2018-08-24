package Day_01.Test05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test05 {
    public static void main(String[] args) {
        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(date));
    }
}
