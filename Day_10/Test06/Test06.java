package Day_10.Test06;

import java.io.*;

// 利用转换输入流将当前项目根目录下使用gbk编码的a.txt文件的内容读取出来，并打印在控制台上
public class Test06 {
    public static void main(String[] args) throws IOException {
        File file  = new File("a.txt");
        InputStreamReader bis =new InputStreamReader( new FileInputStream(file),"gbk");
        char [] b = new char [2];
        int a=0;
        while((a=bis.read(b))!=-1){
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i]);
            }
        }
        bis.close();
    }
}
