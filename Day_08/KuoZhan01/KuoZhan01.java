package Day_08.KuoZhan01;

import java.io.File;

/*
 * 键盘录入一个文件路径，根据文件路径创建文件对象，判断是文件还是文件夹
 * 如果是文件，则输出文件的大小
 * 如果是文件夹，则计算该文件夹下所有文件大小之和并输出(不 包含子文件夹)
 */
public class KuoZhan01 {
    public static void main(String[] args) {
        getInfo(new File("e:\\111\\222"));
        getInfo(new File("e:\\b.txt"));
    }

    public static void getInfo(File file) {
        if (!file.exists()) {
            System.out.println("path don't exists");
        } else {
            if (file.isFile()) {
                System.out.println(file.getName() + "的大小为:" + file.length() + "字节");
            } else {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isFile()) {
                        System.out.println(file1.getName() + "的大小为" + file1.length() + "字节");
                    } else {
                        File[] files2 = file1.listFiles();
                        long size = 0;
                        for (File file2 : files2) {
                            size += file2.length();
                        }
                        System.out.println(file1.getName() + "该文件夹下的所有文件大小之和为" + size + "字节");
                    }
                }
            }
        }
    }
}
