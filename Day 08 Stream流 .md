# 方法引用

`::` 方法引用的符号

对象 `::` 方法   对象名,引用成员方法

> 一般为Lambda 表达式只有一条语句时

### 引用类型

1. 通过对象名引用成员方法
2. 通过类名引用静态方法
3. 类构造函数(构造器)引用 `Person::new`
4. 数组的构造器引用  ` int [] :: new`



# Stream流

## 获取Stream流

* 所有的Collection集合都可以通过stream的默认方法获取流  eg:  list.stream()

* Steam接口的静态方法` of`可以获取数组对应的流

  ```java
  Integer [] arr = {3,8,2,5,0};
  stream.of(arr)
  ```

  ​

### 常用方法

* **终结方法** 返回值不是stream类型的方法,不能链式调用 主要有` count` 和` forEach`

  **终结方法 只能调用一次** 

* **非终结方法** 返回值仍是Stream接口的自身类型的方法,支持链式调用.

####1. 遍历 forEach

`forEach(Consumer<T> c)` 遍历 但不保证有序--->终结方法

#### 2. 统计个数 count

`long count()` 终结方法 返回值是long类型

#### 3. 筛选 filter

`Stream<T> filter(Predicate<? super T> predicate)`  

eg:

```java
Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
Stream<String> result = original.filter(s ‐> s.startsWith("张")); 
```

#### 4. 取前n个 limit

```java
Stream<T> limit(long maxSize)
```

#### 5.跳过前n个 skip

`Stream <T> skip (long n)` 

#### 6. 映射 map

`<R> Stream<R> map(Function<? super T, ? extends R> mapper);` 

将T类型数据 转换为 R类型

```java
import java.util.stream.Stream;   
	public class Demo08StreamMap { 
      	public static void main(String[] args) {         Stream<String> original = Stream.of("10", "12", "18");         Stream<Integer> result = original.map(Integer::parseInt);
	}
}
```

#### 7.组合两个流 concat

`static <T> Strream <T> concat(Stream <? extends T>a ,Stream< ? extends T> b)` 

```java
import java.util.stream.Stream;   
public class Demo12StreamConcat {     
	public static void main(String[] args) {
		Stream<String> streamA = Stream.of("张无忌");         							Stream<String> streamB = Stream.of("张翠山");
      	Stream<String> result = Stream.concat(streamA, streamB);     }
}
```

### 收集Stream结果

收集Stream结果--> Stream对象转为List set 数组......

* 使用Collectors类的方法

  1. Collectors.toList()

  2. Collectors.toSet()

     eg: 

     ```java
     public class Demo15StreamCollect {
     	public static void main(String[] args) {
     		Stream<String> stream = Stream.of("10", "20", "30", "40", "50");
     		List<String> list = stream.collect(Collectors.toList());
     		Set<String> set = stream.collect(Collectors.toSet());
     	}
     }
     ```

     ​

* Stream的toArray() 方法

  ```java
  public class Demo17StreamArray {     public static void main(String[] args) {         Stream<String> stream = Stream.of("10", "20", "30", "40", "50");         String[] strArray = stream.toArray(String[]::new);     
      } }

  ```

  ​

  ​
