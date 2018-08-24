package Day_10.Test04;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 1. 在项目根目录下新建一个文件：data.txt,键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占一行；
	2. 键盘录入一个需要被校验的验证码，如果输入的验证码在data.txt中存在：在控制台提示验证成功，如果不存在控制台提示验证失败
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第1个验证码");
        String str1 = sc.next();
        System.out.println("请输入第2个验证码");
        String str2 = sc.next();
        System.out.println("请输入第3个验证码");
        String str3 = sc.next();
        System.out.println("请输入待校验验证码");
        String str4 = sc.next();

        BufferedWriter bos = new BufferedWriter(new FileWriter(file));
        bos.write(str1);
        bos.newLine();
        bos.write(str2);
        bos.newLine();
        bos.write(str3);
        bos.close();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str="";
        ArrayList<String> list =new ArrayList<>();
        while ((str = br.readLine())!=null){
            list.add(str);
        }
        if (list.contains(str4)){
            System.out.println("验证成功");
        }else{
            System.out.println("验证失败");
        }
        br.close();
    }
}
