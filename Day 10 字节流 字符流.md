# IO 流

IO流本身没有读写功能,如果需要读写,需要调用操作系统的功能, 读写完毕后, 需要告知操作系统,关闭资源.

流对象 一旦被关闭,就不能再使用,

### 文件的续写与换行

续写:

FileOutputStream的构造方法中

​	`FileOutputStream ( String path , boolean append )` 

​		如果append 值为true为续写文件

​		值为false 为覆盖文件,默认为 false

###换行

回车符 \r 和换行符 \n ：

回车符：回到一行的开头（return）。

换行符：另起一行（newline）。

系统中的换行：

-   Windows系统里，每行结尾是 回车+换行 ，即 \r\n ； 
-   Unix系统里，每行结尾只有 换行 ，即 \n ； 
-   Mac系统里，每行结尾是 回车 ，即 \r 。从 Mac OS X开始与Linux统一



在使用 BufferedWriter 写入数据的时候,可以使用其方法 newLine() 来换行

newLine() 方法是根据平台的换行来输出.



### java.io.InputStream

1.   `public void close( )` 
2.   ` piblic abstract rerad( )` 
3.   `public int read( byte [] b )`   读到末尾返回-1

常用子类

FileInputStream

构造方法

`public FileInputStream( String path )`

`public FileInputStream( File file )`

read() 例子-->系统读取到文件结束标记,read()返回-1

```java
public class Demo{
  	public Static void main(String [] args){
    	File file = new File("E:\\111\\bbb.txt");
    	FileInputStream fis = new FileInputStream(file);
    	int len = 0;
    	while((len=fis.read())!=-1){
     	 System.out.println(len)
    }
  }
}
```

read( byte [] b )

```java
public class Demo{
  public Static void main(String [] args){
    	File file = new File("E:\\111\\bbb.txt");
    	byte [] b= new byte [1024];
   	 	FileInputStream fis = new FileInputStream(file);
    	int len = 0;
    	while((len=fis.read(b))!=-1){
      		System.out.println(new String(b,0,len))
        // 将字节数组转换为字符串,最后len表示只打印读到的有效位数
    }
  }
}
```

## 字符流

字符流操作视频 图片等非文本文件,会丢失字节

字符流,如果不刷新 数据不会写入文件(底层带有Buffer)

colse方法,先调用flush刷新后再关闭流.

**FileReader**

构造方法

`FileReader(File file)`

`FileReader(String fileName)`

常用方法

`public void close()`关闭流,释放资源

`public int read()` 读取一个字符数据,返回提升为int的值,如果读到最后返回 -1

`public int read(char[] cubf)` 读取字符数组,读取字符存储在数组中,返回值为读取的有效字符数

```java
public class Demo{
  public static void main (String [] args){
    FileReader fr = new FileReader("E:\\111\\a.txt");
    int len;
    char[] cbuf = new char [1024];
    while((len=fa.read(cbuf))!=-1){
      // String有使用字符数组生成字符串的构造方法
      // String(char [] b,int start , int length)
      // start 为字符数组开始位置索引, length为复制长度
      System.out.printin(new String(cbuf,0,len));
    }
    fr.close;
  }
}
```

## IO异常处理

### jdk 7之前

```java
public class IO_Exception{
  	public static void main(String [] args){
    	FileWriter fw =null;
    	try{
     	 	fw =new FileWriter("fw.txt");
      		fw.write("happy")
   		 }catch(IOException e){
     		 e.printStackTrace();
   		 }finally{
     		 try{
       		 if(fw!=null){
         		 fw.close;
      		  }
     		 }catch(IOException){
        		 e.printStackTrace();
        	}
   		 }
 	}
}
```

#### JDK 7之后

```java
public class IOException{
  public static void main(String[] args){
    try(FileReader fw = new Filereader("fw.txt");){
      fw.write("不能说的秘密");
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
```



## Properties

1.  继承自 Hashtable 实现了Map, 双列集合
2.  这个集合没有泛型 泛型已经确定 键 String 值 String
3.  唯一一个可以与IO流直接结合使用的集合

**特有方法**

`setProperties(String key, String value )`添加数据

`getProperties(String key)`根据键找值

`set<String>stringPropertiesNames()`获取键的集合

```java
public class Properties_Demo{
  public static void main(String [] args){
    Properties p = new Properties();
    p.setProperties("name","liuyan");
    p.setProperties("age","38");
    
      
  }
}
```

#### 与IO流结合使用

`load(InputStream in)`将文件中的键值对,加载到集合中

`load(Reader r)`将文件中的键值对,加载到集合中

方法参数

InputStream in 是抽象类,需要传递其实现子类FileInputStream

Reader r   是抽象类,需要传递其实现子类 FileReader



config.properties--->配置文件