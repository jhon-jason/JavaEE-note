# Map

## Map 集合

Map-> 映射 代表一一对应的关系.

Map <K,V> 键值对   Key 键 Value 值--> 键不可以重复 值可以重复

### 常用方法

`public V put( K k,V v)`  添加元素 返回值一般为null,当键值有重复的时候,返回值为**被覆盖的值**.

```java
class Demo{
  	public static void main(String [] args){
      	Map<String,Integer> map =new HashMap<>();
      	int value1=map.put("影魔",1000);
      	// value1=null
      	int value2=map.put("影魔,"9000);
      	// value2 =1000  ->返回值为替换前的值
  	}
}
```

`public V remove(Object key)`将指定键值对应的元素移除,并返回移除的值

`pubic V get (Object key)` 根据指定的键 在Map集合中 获取对应的值

`public Set <K> keySet() ` 获取Map集合中所有的键 返回值 为存储所有键的Set集合

`public Set<Map.Entry<K , V>> entrySet() `获取集合中的所有键值对 存储到Set集合中返回



### 常用实现类

* HashMap

  键 无序唯一

* LinkedHashMap

  键 有序唯一

### 遍历方式

#### 1. 根据键 获取值

​	Set<K> keySet()  返回一个Set集合 存储到Map集合所有的键



#### 2. 键值对,方式

​	`Set<Map.entey<K,V>> entrySet()`

​	getKey()

​	getValue()

### HashMap 集合存储自定义类型的键值

要保证存储的键不重复,必须重写 自定义类型的 hashCode和equals方法





## Jdk9优化

of() 创建不可变集合,得到的集合只能查询操作

List Set Map 接口的静态方法,只能是接口调用,

```java
public class Demo{
  public static void main(){
    	Set<String> set1=Set.of("a","b","c");
    	// 添加了一个长度不可以改变的集合
    	set1.get()
  }
}
```





