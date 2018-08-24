package Day_09.Test02;
// 利用字节输出流一次写一个字节数组的方式向D盘的b.txt文件输出内容:"i love java"。
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) throws IOException {
        String str = "i love java";
        byte[] bytes = str.getBytes();
        File file = new File("E:\\b.txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
    }
}
