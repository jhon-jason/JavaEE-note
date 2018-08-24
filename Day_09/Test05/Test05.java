package Day_09.Test05;
/*
*描述:利用字节输入流读取D盘文件b.txt的内容，文件内容确定都为纯ASCII字符
* ,使用循环读取，一次读取一个字节数组，直到读取到文件末尾，将读取到的字节数组转换成字符串输出到控制台。
 */
import java.io.FileReader;
import java.io.IOException;

// 预习写法
/*
public class Test05 {
    public static void main(String[] args) throws IOException {
        // int read(char[] cbuf)
        FileReader fr = new FileReader("E:\\b.txt");
        char [] cbuf= new char[4];
        for (int a=fr.read(cbuf);a>0;a=fr.read(cbuf)) {
            if (a<4){
                for (int i=0;i<a;i++){
                    System.out.print(cbuf[i]);
                }

            }else{
                System.out.print(cbuf);
            }
        }
        fr.close(); // 预习时没有关流资源
    }
}
*/

// 课后写法
public class Test05 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("E:\\b.txt");
        char [] cbuf= new char[4];
        for (int a=fr.read(cbuf);a>0;a=fr.read(cbuf)) {
            System.out.print(new String(cbuf,0,a));
        }
        fr.close();
    }
}