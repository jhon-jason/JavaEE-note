# File类 递归 字节流

## File 类

`java.io.File` 平台无关性: 

静态的成员变量

 `static String pathSeparator` 路径分割符  windows   ;    linux   :

`static String separator` 名称分隔符

windows  \   linux  /

**绝对路径 和相对路径**

绝对路径: 唯一性  从根盘符开始的全部都是绝对路径

G:\\aba\\sfds\\1.txt

相对路径: 不带根盘符的都是相对路径

java类中的相对路径,都是根据project的路径创建的

相对路径可以有多个 

一个文件的父路径是唯一的 

G:\\\abc\\\eee

子路经可以有多个

1.txt a.txt



\\abc

\abc\a.txt

\abc\b.txt

\abc\aaa\c.txt

在a.txt引用b.txt===== 直接写`b.txt`  ( 平级 )

在c.txt引用a.txt===  ` . . \a.txt `  (aaa与a.txt平级 需要..返回上一级)

### 构造方法

- ` public File ( String pathname )`   通过指定的路径字符串创建File实例

  路径存在与不存在都可以

-  `public File ( String parent ,String child )`  通过父路径和子路径创建File实例

  父路径为绝对路径 子路经为子路径

  经整个路径拆分为两个部分,路径更为灵活

-  `public File ( File parent , String child ) `  从抽象路径和子路径创建File实例

  **File类的父路径,可以调用File的方法 **

###常用方法

获取方法

-  `public String getAbsolutePath( ) ` 获取绝对路径

- `piblic File getAbsoluteFile()`  返回此抽象路径名的绝对路径名形式。

-  `public String getPath( ) ` 获取构造方法中的路径---可以为相对路径也可以为绝对路径

-  `public String getName( )  `    获取文件或目录的名称

-  `public long length( )`  获取文件的长度

  > 只能获取文件的字节数,不能获取文件夹,如果不存在 返回 0

判断方法

-  `public boolean exits( ) ` 文件或目录是否存在

- ` public boolean  isDirectory( )`  是否为目录

-  `public boolean isFile( )`      是否为文件

  > 是文件 true 是文件夹 false 路径不存在 false

创建或删除的方法

-  `public boolean createNewFile( ) ` 如果不存在,创建文件

  windows操作系统不区分大小写 a.txt和A.txt是一个文件

-  `public boolean delete( ) `     删除文件或者目录

  > 如果文件夹中有文件或者文件夹 无法删除

-  `public boolean mkdir( ) `  创建目录

  只能创建单级文件夹

- ` public boolean mkdirs( ) `     创建所有不存在的目录

目录遍历

-  `public String [] list( ) `     返回所有目录中的文件或目录的名字

  只能是指向文件夹的File对象调用,如果指向文件的File对象调用 返回null ,如果路径不存在 也返回null

  返回的是单级目录下的所有文件夹或文件

-  `public File []  listFiles( )`  返回目录中所有目录或文件的对象

## 递归

方法的递归: 方法调用自身的情况

递归的注意事项:

1. 递归需要有一个出口,否则就是死递归
2. 递归的次数不宜过多,容易造成内存溢出
3. 构造方法不能递归

递归获取文件夹下所有文件

```java
public class DiGui{
    public static void main(String [] args){
        File file =new File("G:\\abc");
    
    }
    public static void show(File srcDir){
        File [] files = srcDir.listFiles();
        for(File thisFile : files){
            if(thisFile.isFile){
               System.out.println(thisFiles)
            }else{
         	    show(thisFile) 
             }
         }
    }
}
```

## IO概述

input output

输入输出以程序为基准(内存)

从内存中写到其他地方 叫输出

从其他地方读到内存中 叫输入



字符流只能操作文本文件:   txt  .java  .xml  .html .css