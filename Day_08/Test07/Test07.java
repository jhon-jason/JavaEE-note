package Day_08.Test07;

import java.io.File;

public class Test07 {
    public static void main(String [] args){
        File file = new File("e:\\111");
        if (file.isFile()){
            System.out.println(file.getName()+"是一个文件");
        }else{
            System.out.println(file.getName()+"不是一个文件");
        }
    }
}
