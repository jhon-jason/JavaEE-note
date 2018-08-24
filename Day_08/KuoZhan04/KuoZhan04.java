package Day_08.KuoZhan04;

import java.io.File;

// 获得指定文件夹下所有的java文件(不考虑子文件夹的)并输出到控制台
public class KuoZhan04 {
    public static void main(String[] args) {
        File file = new File("E:\\111");
        File [] files = file.listFiles();
        for (File file1 : files) {
            boolean b = file1.getName().toLowerCase().endsWith(".java");
            if (b){
                System.out.println(file1.getName());
            }
        }
    }
}
