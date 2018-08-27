# 网络编程

## 软件结构

* C/S  结构    Client Server 结构  客户端 服务器结构
* B/S  结构    Browser Server 结构  浏览器 服务器结构

## 网络协议

* **TCP/IP协议**  (传输控制协议/因特网互联协议)

  ​     **面向连接**   

  *三次握手* 

  * 第一次握手: 客户端向服务端发出连接请求
  * 第二次握手: 服务器向客户端回送一个响应,通知客户端收到了连接请求
  * 第三次握手: 客户端再次向服务器发送确认信息,确认连接.

* **UDP协议** 

  ​	**面向无连接** 

  | 协议   | 特点       | 可靠性    | 数据大小    | 消耗资源         | 传输速度   |
  | ---- | -------- | ------ | ------- | ------------ | ------ |
  | TCP  | **面向连接** | 可靠 无差错 | 数据大小无限制 | 系统资源要求较**多** | 传输速度稍慢 |
  | UDP  | 面向无连接    | 可能丢包   | 每条最大64K | 系统资源要求较**少** | 传输速度快  |



## 网络编程三要素

* **协议**   计算机网络通信必须遵守的规则

* **IP地址**   互联网协议地址,  P地址用来给一个网络中的计算机设备做唯一的编号

* **端口号**    计算机为应用程序分配的唯一标识 0-65535

  ​			前1024 已被系统占用.


## TCP通信

1. 客户端 java.net.**Socket**
2. 服务端 java.net.**ServerSocket**

### Socket类

* **构造方法**

  `public Socket(String host, int port)`

  > 例如:`Socket client = new Socket("127.0.0.1", 8888);` 

  > `Socket client = new Socket("localhost", 8888);` 

  > 127.0.0.1 与localhost相同

* **成员方法**

  1. `public InputStream getInputStream()`  返回客户端输入流
  2. `public OutputStream getOutputStream()` 返回客户端输出流
  3. ` public void close()` 关闭客户端
  4. `public void shutdownOutput()` 禁用客户端获取的输出流(一般在循环读取时注意)

### ServerSocket类

* **构造方法** 

  `public ServerSocket(int port)` 

* **成员方法** 

  1. `public Socket accept()` 侦听连接,如有客户端连接 返回连接的客户端对象

```java
public class Server_Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动，等待链接");
        //1.创建 ServerSocket对象，绑定端口，开始等待连接
        ServerSocket ss = new ServerSocket(9999);
        //2.接收连接 accept 方法, 返回 socket 对象
        Socket socket = ss.accept();
        // 3.通过socket 获取输入流
        InputStream in = socket.getInputStream();
        // 4.一次性读取数据
        // 4.1 创建字节数组
        byte[] b = new byte[1024];
        int l;
        while ((l = in.read(b))!=-1){
            System.out.println(new String(b,0,l));
        }
        //回写数据
        OutputStream out = socket.getOutputStream();
        out.write("你好陈奕迅".getBytes());
        socket.shutdownOutput();
        //5.关闭资源.
        in.close();
        out.close();
        ss.close();
    }
}
```

```java
public class Client_Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端 发送数据");
        //创建客户端
        Socket s = new Socket("127.0.0.1",9999);
        // 2.获取流对象 . 输出流
        OutputStream o = s.getOutputStream();
        // 3.写出数据.
        o.write("你好周杰伦".getBytes());
        //接受客户端
        s.shutdownOutput();
        InputStream in = s.getInputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = in.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        //4. 关闭资源
        o.close();
        in.close();
        s.close();
    }
}
```

