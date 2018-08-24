package Day_01.Test01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
        String format = sf.format(date);
        System.out.println(format);

    }
}
