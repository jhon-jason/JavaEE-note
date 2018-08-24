package Day_10.Test02;

import java.io.*;

// 描述:利用高效字节输出流往C盘下的e.txt文件写出一个字节数组数据，如写出：”i love java”
public class Test02 {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream(new File("E:\\111\\e.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write("i love java".getBytes());
        bos.close();
        os.close();
    }
}
