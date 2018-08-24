# Day 03 List Set 数据结构 Collections

## List

**List集合特点**

1. List 是有序的 存储顺序和取出顺序是一致的.
2. List 是有索引的.
3. 元素可重复
4. 线程不安全 效率高

### 常用子类

* ArrayList
* LinkedList

### 常用方法 -ArrayList

` public void add( int index , E element ) `将指定元素增加到集合的指定位置

`public E get( int inidex )` 返回集合中指定位置的元素

` public E remove (int index ) ` 移除指定位置的元素,返回值是删除的元素

` public E set ( int index , E element ) ` 用指定元素替换集合中指定位置的元素,返回值为更新前的元素.

**三种遍历方式**

普通for

增强for

迭代器



### linkedList 集合

双向链表

#### 常用方法

`public void addFirst(E e)`  :将指定元素插入此列表的开头。 

`public void addLast(E e) ` :将指定元素添加到此列表的结尾。 

`public E getFirst()`  :返回此列表的第一个元素。 

` public E getLast() ` :返回此列表的后一个元素。

`public E removeFirst() ` :移除并返回此列表的第一个元素。 

`public E removeLast() ` :移除并返回此列表的后一个元素。

 `public E pop() :` 从此列表所表示的堆栈处弹出一个元素。

`public void push(E e)`  :将元素推入此列表所表示的堆栈。 

`public boolean isEmpty()`  ：如果列表不包含元素，则返回true。





## Set 接口

**特点**

1. 无序的(LinkedHashSet 除外)
2. 元素唯一的
3. 线程不安全,效率高

#### 常用子类

* HashSet
* LinkedHashSet

### HashSet保证元素唯一的方法

```java
先比较两个对象的hashCode
		不同  添加到集合
		相同  继续比较equals
				不同 添加到集合
				相同  不添加
```

### HsahSet 存储自定义类型

保证存储数据不重复,必须重写hashCode和equals方法





## 数据结构

### 是什么

数据以什么方式组合在一起

### 常见数据结构

数据存储的常用结构为: 栈  队列  数组  链表  红黑树

#### 栈 stack

是运算受限的线性表

特点:        **先进后出**

* **压栈** 存元素
* **弹栈** 取元素

#### 队列  queue

运算受限的线性表

特点  **先进先出**



#### 数组 Array

数组是内存中的一段**连续** 的空间

**特点**

**查询快 增删慢**



#### 链表 linked list

单向链表 **查询慢 增删快** 

双向链表  **查询慢 增删快 保证有序 **  



#### 红黑树

趋近平衡的二叉树

特点 **查询快**





