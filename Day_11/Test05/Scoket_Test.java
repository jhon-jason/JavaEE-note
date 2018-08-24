
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Scoket_Test {
    public static void main(String[] args) throws IOException {

        Socket sc = new Socket("192.168.31.31",8888);

        OutputStream outputStream = sc.getOutputStream();
        outputStream.write("happy".getBytes());
        outputStream.flush();
       // outputStream.close();
        //sc.close();
        InputStream inputStream = sc.getInputStream();
        byte [] b = new byte[1024*10];
        int len;
        len = inputStream.read(b);
        System.out.println(new String(b,0,len));
    }
}

