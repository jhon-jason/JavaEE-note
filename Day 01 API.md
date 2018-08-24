# Day 01 API

##1. Object 类

- `java.lang.Object`是所有类的超类.所有类,默认继承Object类

#### 常用方法

> `toString`  返回对象的字符串. 
>
> `equals`  Object 类中的equals 方法是对比两个对象的地址值, 其他类,多数重写此方法.

* equals 方法对比两个对象, **默认为比较地址** ,如果子类重写了equals方法,可以实现对对此对象的 **属性内容** 进行比较

  ​

## 2. 时间日期类

### Date 类

表示时间, 返回Date对象.

* 构造方法

  > 空参构造  `public Date()`
  >
  > 有参构造`public Data(Long data)` 标准基准时间1970-1-1 00:00:00 

  ####常用方法

  > `public long getTime()` 将日期对象返回long类型的毫秒值

### DateFormat 类

* 抽象类,其常用的实现类是 `SimpleDateFormat` 

```java
// SimpleDateFormat 格式化日期
public class Test01 {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
        String format = sf.format(date);
        System.out.println(format);
    }
}

// out->2018-08-06 05:38:37 周一
```

**格式规则**

| 标识字母 | 含义   |
| ---- | ---- |
| y    | 年    |
| M    | 月    |
| d    | 日    |
| H    | 小时   |
| m    | 分钟   |
| s    | 秒    |
| E    | 星期   |

#### 常用方法

* 日期格式格式化为字符串

  `format` 

  ```java
  	Date date = new Date(); /* 创建日期格式化对象,在获取格式化对象时可以指定风格 */
   	DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
  	String str = df.format(date);
  ```

  ​

* 字符串格式化为Date对象

  `parse`

  ```java
   	DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");         
  	String str = "2018年12月11日";         
  	Date date = df.parse(str);         
  	System.out.println(date); 
  ```

  ​

### Calender 类

* `java.util.Calender`  替代Date的方法
* 抽象类, 使用静态方法返回Calender的实现子类(`getInstance`)

```java
public class Test07 {
    public static void main(String[] args) {
        Calendar cal=Calendar.getInstance();
      // 多态应用, 父类引用指向子类对象
      // Calender为抽象类,其静态方法getInstance 返回Calender的实现子类对象
```

#### 常用方法

* add 按照日历的规则增加相应的字段
* set  设置相应字段的值
* get 返回相应字段的值
* getTime 将Calender时间的值返回Date对象

**常用字段**

| 字段值          | 含义             |
| ------------ | -------------- |
| YEAR         | 年              |
| MONTH        | 月->由0开始到11     |
| DAY_OF_MONTH | 日              |
| HOUR         | 时 12小时         |
| HOUR_OF_DAY  | 时 24小时         |
| MINTE        | 分              |
| SECOND       | 秒              |
| DAY_OF_WEEK  | 星期值 从周日开始,周日为1 |

`add`方法

## 3. System 类

定义在`java.lang.System` 提供大量静态方法

### 常用方法

#### currentTimeMillis 方法

返回与标准时刻 1970-01-01 00:00:00 的毫秒值

#### arraycopy 方法

将数组中的一部分copy到另一个数组的指定位置

`public static void arraycopy(Object str, int srcPos, Object dest, int desPos, int length)`



## 4 . StringBuilder 类

理解为字符串的缓冲区

### 构造方法

* 空参构造 ` public StringBuilder()` 产生一个空的缓冲区
* 有参构造` public StringBuilder(String str)`产生一个有传入字符串的字符串缓冲区.

### 常用方法

* append  添加元素

* toString  返回字符串

  ​

**StringBuilder 清空** 

> StringBuilder没有提供Clear
>
> 清空StringBuilder可以使用delete,效率较高

```JAVA
StringBuilder sb=newStringBuilder;

Sb.apend……

Sb.delete(0,sb.legth()); // 删除所有元素

```



## 5. 包装类

| 基本类型    | 对应包装类         |
| ------- | ------------- |
| byte    | Byte          |
| short   | Short         |
| int     | **Integer**   |
| long    | Long          |
| float   | Float         |
| double  | Double        |
| char    | **Character** |
| boolean | Boolean       |

**装箱和拆箱**

* 装箱 基本数据类型-->包装类

  Integer i=4 ;

* 拆箱 包装类-->基本数据类型

  i=i+4;

  ​

