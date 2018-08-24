# Day02 Collection & Iterator & 泛型

## Collection 

### Collection 与数组

* 数组: 长度固定不变,可以存放任意类型的元素
* 集合:长度可变,只能存放引用数据类型



> > 数组 .length 是属性

> > 集合 .size() 是方法

> >  字符串 .length() 是方法

### Collection 继承体系

**Collection**   接口

> **List**  接口  有序 可重复
>
> > > ArrayList
> > >
> > > LinkedList

> **Set **  接口  无序 不可重复
>
> > > HashSet
> > >
> > > > > LinkedHashSet
> >
> > > TreeSet



### Collection常用方法

* `public boolean add(E e) `：  把给定的对象添加到当前集合中 。
* ` public void clear()` :清空集合中所有的元素。
* `public boolean remove(E e)` : 把给定的对象在当前集合中删除。
* ` public boolean contains(E e)` : 判断当前集合中是否包含给定的对象。 
* `public boolean isEmpty() `: 判断当前集合是否为空。
* `public int size()` : 返回集合中元素的个数。
* `public Object[] toArray() `: 把集合中的元素，存储到数组中。




## Iterator 迭代器

Iterator 是接口, 用于遍历集合.  

* **获取迭代器**

```java
public interface Collection{
  public abstract Iterator iterator();
}
// Collection 为接口,接口中有返回值为抽象类对象Iterator的抽象方法

public class ArrayList implements Collection{
  public Iterator iterator(){
    	return Iterator  //返回实现类的对象
  }
}

Collection c= mew ArrayList();
// 多态方法创建对象
Iterator it =c.iterator();  
// c.iterator() 调用实现类方法 返回实现类的对象
it.hasNext();
it.next();
// it为子类实现对象,可以调用其方法.
```

  **获取集合的迭代器, 方法是抽象方法,但是 Collection接口的实现类一定重写此方法,方法的返回值类型是接口,重写时一定会返回接口的实现类对象,也就是迭代器的实现类对象,所以可以直接调用其方法 ** 

---



### 常用方法

* `public E next() ` :返回迭代的下一个元素

  > next 方法 **每调用一次都会移动一次指针,获取一次元素**

* `public boolean hasNext() ` :如果仍有元素可以迭代，则返回 true。 


**并发修改异常**

* 当迭代器正在迭代集合时，集合修改了其长度就会报此异常。
* 当迭代器遍历 或者增强for循环遍历时 不要修改集合的长度

```java
public class Iterator_Test {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");

        Iterator<String> it = c.iterator();
        int flag = 0;
        while (it.hasNext()) {
            String name = it.next();
            if ("a".equals(name)) {
                c.add("f"); // 并发修改异常 Iterator 遍历时,对集合进行增加长度
            }
        }
    }
}
```







## 增强For

格式:

```java
for(元素的数据类型  变量 : Collection集合or数组){    
  //写操作代码    
}
  
```

作用: 遍历数组.







## 泛型

泛型可以使用在 接口 类 方法上  ----> 将数据类型当作参数传递.

泛型只能是引用数据类型

###定义泛型

* 好处  : 预先使用未知的类型. 

### 使用泛型

* 当我们创建集合对象时,给定集合元素的类型,就是使用泛型,给定的元素类型作为参数,传递到了方法的参数列表. 
* **使用泛型的好处**

> > > 1.将运行时异常提前到编译时.
> > >
> > > 2.避免了向下转型的麻烦和可能出现的强制转换异常.



#### 泛型类

```java
public class 类名 <泛型类型>{
}
```

创建类的对象

####泛型方法

```java
修饰符 <泛型变量> 返回值类型 方法名(){
 
}
```

* 当调用方法时 确定泛型的数据类型

#### 泛型接口

```java
public interface 接口名<泛型变量>{
}
```

1. 当定义实现类时 直接确定泛型的数据类型
2. 定义实现类时，不确定泛型的类型 创建实现类对象时确定泛型的数据类型







### 泛型的通配符  ?



```java
public class Test {
    public static void main(String[] args) {
      	ArrayList<Integer>list=new ArrayList<>();
      list.add(100);
      list.add(200);
      ArrayList<String>list=new ArrayList<>();
      list.add("abc");
      list.add("nfk");
    }
  //使用泛型统配符
  public static void show(ArrayList<?> list){
    for(Object obj:list){
      System.out.print(obj);
    }
  }
  //使用泛型方法
  public static <E> void show(ArrayList<E> list){
    for(E e:list){
      System.out.print(e)
    }
  }
}
```

#### 泛型的限定

* 上限限定   `? extends xxx `   只能传 xxx及xxx的子类
* 下限限定   ` ? super  xxx`   只能传 xxx及 xxx的父类









## 可变参数

本质上是个数组

使用前提

参数的类型确定,参数的个数不确定

格式

`参数类型  ... 变量名`





* 注意事项

> 1. 一个方法只能有1个可变参数
> 2. 一个方法有多个参数,可变参数要放到最后
> 3. Object ... obj 任意类型 任意个参数.

