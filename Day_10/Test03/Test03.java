package Day_10.Test03;

import java.io.*;

/*
描述:利用高效字节输入流和高效字节输出流完成文件的复制。
要求：
1.将C盘下的c.png文件复制到D盘下
2.一次读写一个字节数组方式复制
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(new File("E:\\111\\a.png"));
        BufferedInputStream bis = new BufferedInputStream(is);
        OutputStream os =new FileOutputStream( new File("E:\\111\\222\\a.png"));
        BufferedOutputStream  bos = new BufferedOutputStream(os);
        byte [] b = new byte[1024];
        int read =0;
        while((read = bis.read(b))!=-1 ){
            bos.write(b);
            bos.flush();
        }
        bos.close();
        os.close();
        bis.close();
        is.close();

    }
}
