package Day_09.Test06;

import java.io.*;

public class Test06 {
    public static void main(String[] args) throws IOException {
        File file= new File("E:\\a.png");
        File file1= new File("E:\\a_copy.png");
        FileInputStream fr= new FileInputStream(file);
        FileOutputStream fw =new FileOutputStream(file1);

//        while(fr.read()!=-1){
//            fw.write(fr.read());
        int read = fr.read();
        while(read!=-1){
            fw.write(read);
            read=fr.read();
        }
        fw.flush();
        fw.close();
        fr.close();
    }
}
