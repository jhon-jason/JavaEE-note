package Day_09.Test01;
// 利用字节输出流一次写一个字节的方式，向D盘的a.txt文件输出字符‘a’。
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) throws IOException {
        File file= new File("E:\\a.txt");
        FileOutputStream fos= new FileOutputStream(file);
        fos.write('a');
        fos.flush();
        fos.close();
    }
}
