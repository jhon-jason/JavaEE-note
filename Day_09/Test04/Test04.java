package Day_09.Test04;
/*
 *利用字节输入流读取D盘文件a.txt的内容，文件内容确定都为纯ASCII字符
 * 使用循环读取，一次读取一个字节，直到读取到文件末尾。将读取的字节输出到控制台
 */

import java.io.FileReader;
import java.io.IOException;

public class Test04 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\b.txt");
        // 使用for
        for (int i = fr.read(); i > 0; i = fr.read()) {
            System.out.print((char) i);
        }
        fr.close();

        // 使用while
        int i;
        while ((i=fr.read())!=-1){
            System.out.print((char)i);
        }
        fr.close();
    }
}
