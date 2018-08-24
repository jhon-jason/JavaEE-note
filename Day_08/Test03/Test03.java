package Day_08.Test03;

import java.io.File;
import java.io.IOException;

public class Test03 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("a.txt");
        f1.createNewFile();
        File f=new File("E:\\aaa");
        f.mkdirs(); // mkdir 与 mkdirs 区别为 s创建所有目录
        boolean exists = f.exists();
        System.out.println(exists);

        File fi = new File("E:\\ccc\\bbb\\aaa");
        System.out.println(fi.mkdirs());
        File f2 = new File("E:\\ccc\\bbb\\aaa\\b.txt");
        f2.createNewFile();
        //f1.delete();
        //f.delete();
        String name = f2.getName();
        System.out.println("getname"+name);
        String parent = f1.getParent();
        System.out.println("getParaent"+parent);
        File parentFile = f1.getParentFile();
        System.out.println("geyParaentFile"+parentFile);

    }
}
