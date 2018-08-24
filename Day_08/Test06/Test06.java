package Day_08.Test06;

import java.io.File;

public class Test06 {
    public static void main(String [] args){
        File file = new File("E:\\111\\b.txt");
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
    }
}
