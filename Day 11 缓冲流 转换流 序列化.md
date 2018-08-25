# 缓冲流

缓冲流需要刷新才能写入数据

**字节缓冲流** 

`BufferedInputStream`

`BufferedOutputStream`

**字符缓冲流**

`BufferedReader`

`BufferedWriter`

## BufferedOutputStream

继承了OutputStream

`write(int b)`

`write(byte[] byte)`

`write(byte[] bytes, int start , int length)`

### 构造方法

`BufferedOutputStream(OutputStream out)`

参数为字节输出流的超类,可以传入任意子类对象,一般为FileOutputStream

```java
public class Demo{
  public static void main(String[] args){
    	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\111\\2.txt",true));
    	bos.write(100);
    	bos.flush();
    	bos.close;
  }
}
```

## BufferedInputStream

继承InputStream

`read()`

`read(byte[] bytes)`

`read(byte[] bytes , int start , int length)`

### 构造方法

`BufferedInputStream(InputStream in)`

## BufferedReader

继承自 Reader

`read()`

`read(char[] chs)`

`read(char[] chs , int start , int length)`

`read(String str)` 

**特有方法**

`String readLine()`一次读取一行



四大皆空

String s = "";

String s = "null";

String s =  null;

public void method(){}



## BufferedWriter

继承自 Writer

`write(int b)`

`write(char [] chs )`

`write(String str)`

**构造方法** 

`BufferedWriter(Writer w)`

**特有方法**

`static void newLine()`写出符合操作系统的换行

# 转换流

## 字符编码和字符集

* 字符编码就是自然语言与二进制的对应关系
* 字符集 也叫编码表,是一个系统支持的字符的集合 所有的码表都兼容 ASCII

**GBK**  两个字符表示一个汉字

**UTF-8**   三个字符表示一个汉字



### InputStreamReader

**构造方法**

`InputStreamWriter(InputStream out)`

`InputStreamWriter(InputStream out, String charseName)`



## OutputStreamWriter

继承自 Writer

可以使用父类的write方法

### 构造方法

`OutputStreamWriter(OutputStream out)`

`OutputStreamWriter(OutputStream out, String charseName)`

charseName: 如果不指定,按照工作空间指定码表

指定码表可以写字符串的码表名称 不区分大小写 eg:"gbk"   "GBK" "utf-8"

```java
public class Demo{
  public static void main (String [] args){
    InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\111.txt"),"gbk");
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\111\\111.txt"),"utf-8");
    int read;
    while((read=isr.read())!=-1){
      osw.write(read);
    }
    osw.close();
    isr.close();
  } 
}
```



##序列化

实现Serializable 序列化接口的类才可以进行序列化操作

没有任何方法: 标记型接口

静态内容不能序列化的

transient 瞬态关键字 阻止序列化修饰的关键字.

**ObjectOutputStream类**

构造方法

`public ObjectOutputStream(OutStream out)`

写出对象-->序列化

`public final void writeObject (Object obj) `

**ObjectInputStream类**

构造方法

`public ObjectInputStream(InputStream in)`

读取对象-->反序列化

`public final Object readObject () `

```java
public class Persion implements Serializable {
  		private String name;
  		private String gender;
  		private transient int age;// transient 瞬态标识 阻止该变量被序列化
  		private static String class; // 静态的变量 不会被序列化  序列化的对象是对象,而静态的变量属于类.
     private static final long serialVersionUID = 121L;// 自定义序列号,避免修改对象类造成无法反序列化
  		.......省略构造函数和getter和setter
}
// 序列化过程
public class Serializable{
  public static void main(String [] args){
    Persion p = new Persion("巫妖","男",1000,"暗夜");
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("hero.txt"));
    out.writeObject(p);
    out.close();
  }
}
// 反序列化过程
public class Demo {
    public static void main(String[] args) throws Exception {
        Persion p = null;
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("E:\\hero.txt"));
        Object obj= in.readObject();
        p = (Persion)obj;
        System.out.println(p);
        in.close();
    }
}
```



## 打印流

PrintStream 这个流只负责输出

继承自 OutputStream

**特有方法**

print()

println()

**构造方法**

PrintStream()