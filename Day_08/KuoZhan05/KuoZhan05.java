package Day_08.KuoZhan05;

import java.io.File;
import java.util.Scanner;

/*
 * 键盘录入一个文件夹路径，删除该文件夹以及文件夹路径下的所有文件。
 * 要求：录入的文件夹里面要有多个文件，不能包含有子文件夹。
 * 提示：如果文件夹里面有文件，则需要先将文件删除才能删除文件夹
 */
public class KuoZhan05 {
    public static void main(String[] args) {
        System.out.println("请输入路径");
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        delete_all(new File(next));
    }

    public static void delete_all(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (!file1.exists()) {
                System.out.println("路径不存在");
            } else if (file1.isFile()) {
                file1.delete();
            } else {
                delete_all(file1);
                file1.delete();
            }
        }
    }
}

