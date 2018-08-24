package Day_10.Test01;

import java.io.*;

// 描述:利用高效字节输出流往C盘下的d.txt文件输出一个字节数
public class Test01 {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream(new File("e:\\111\\d.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write('a');
        bos.close();
        os.close();
        while(true);
    }
}
