package Day_08.Test08;

import java.io.File;

/*
 * 获取指定文件夹下所有的文件，并将所有文件的名字输出到控制台。
 * 注意：不包含子文件夹下的文件
 */
public class Test08 {
    public static void main(String[] args) {
        File file = new File("e:\\111");
        File [] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
    }
}
