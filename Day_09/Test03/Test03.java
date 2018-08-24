package Day_09.Test03;

import java.io.*;

public class Test03 {
    public static void main(String[] args) throws IOException {
        String str = "\r\ni love java ";
        byte[] bytes = str.getBytes();
        File file = new File("E:\\c.txt");
        FileOutputStream fos= new FileOutputStream(file,true);

        for (int i = 0; i < 5; i++) {

            fos.write(bytes);

        }
        fos.close();

        BufferedWriter bf = new BufferedWriter(new FileWriter("E:\\d.txt"));
        bf.newLine();
        bf.write("heuma\r\n");
        bf.write("cheng");
        bf.newLine();
        bf.write("shafhds");
        bf.write("=======sfsadg");
        bf.flush();
        bf.close();
    }
}
