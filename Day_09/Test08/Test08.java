package Day_09.Test08;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Test08 {
    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            p.load(new FileReader("score.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> strings = p.stringPropertyNames();
        for (String string : strings) {
            if ("lisi".equals(string)){
                p.setProperty(string,"100");
            }
        }
        try {
            p.store(new FileOutputStream("score.txt"),"sunzj-18-09-23 modified");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
