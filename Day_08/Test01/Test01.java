package Day_08.Test01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 描述:创建两个文件对象，分别使用相对路径和绝对路径创建。
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
    String pathname="E:\\heima.txt";
        File file=new File(pathname);
        new File("E:\\iiiiii.txt").createNewFile();
        FileOutputStream fos= new FileOutputStream(file);
      // file.createNewFile("heima.txt");
        String fpath="E:\\heima";
        String cpath="chengxuyuan.txt";
        File file1=new File(fpath,cpath);
    }
}
