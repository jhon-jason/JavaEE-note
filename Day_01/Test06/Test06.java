package Day_01.Test06;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test06 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sf.parse("2018-03-04");
        System.out.println(sf.format(date1));
        SimpleDateFormat sf2=new SimpleDateFormat("yyyy 年 MM 月 dd 日");
        System.out.println(sf2.format(date1));
    }
}
