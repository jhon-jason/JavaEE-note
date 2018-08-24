

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Test5 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream socketInputStream = socket.getInputStream();
        byte [] b =new byte[1024*10];
        int len = socketInputStream.read(b);
        System.out.println(new String(b,0,len));
        //socketInputStream.close();
        ss.close();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("love".getBytes());
        outputStream.flush();

    }
}






