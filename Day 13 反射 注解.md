# Junit 反射  注解

## 1. Junit单元测试

简单理解:可以在测试中取代main方法,直接运行单元代码

测试分类:

* 黑盒测试:  给定输入值,测试程序是否输出期望值
* 白盒测试: 通过代码进行测试-->压力测试

1. IDEA自带Junit可以直接使用
2. 导入Jar包
   1. 创建lib文件夹
   2. 将jar包放入文件夹
   3. project Structure---Dependencies--加号----JARS or directiors

使用Junit 单元测试的代码,必须是无参无返回值的代码--->可以独立运行的代码

单元测试步骤

1. 定义无参无返回值的方法
2. 在方法中加上@Test的注解
3. 点击测试方法名,运行需要测试的方法
4. 点击空白,或者点击类名右键运行,是运行所有带有@Test注解的方法.

```java
public class Junit_Deno{
  @Before
  public void method1{
    System.out.println("之前");
  @Test
  public void method1{
    System.out.println("单元测试1");
  @After
  public void method1{
    System.out.println("之后");
  @Test
  public void method1{
    System.out.println("单元测试2");
  }
}
    // 输出
    之前
    单元测试1
    之后
    之前
    单元文件2
    之后
```



## 2. 反射

class文件又被称为字节码文件

java.lang.**Class**  java中描述class文件(字节码)的类

Class的对象不是new 出来的 ,而是jvm创建的,我们可以获取使用.

当创建对象时,这个类的class文件就会加载到内存中,jvm会为这个class文件创建一个Class类型的对象

### 2.1 **什么是反射** 

**获取内存中的Class类型对象,并通过对象操作字节码文件,获取字节码内容并运行使用** 

* 获取构造方法并运行
* 获取成员变量,并赋值或获取值
* 获取成员方法,并运行



类似与Person类

具备空参构造方法，私有成员变量，get/set方法，我们称为JavaBean类（实际上标准的JavaBean类还需要实现序列化）

`com.itheima.bean `

### 2.2 获取字节码文件的三种方式（重要）

> 说明： 同一个字节码文件在一次程序运行中只会加载一次，无论哪种方式获得的字节码文件都是同一个。

1. **Object类的getClass()方法**

   Class  getClass()

   ```java
   public class GetClassDemo{
     public static void main(String[] args){
       Person p = new Person();
      Class c = p.getClass();
     }  
   }
   ```

   ​

2. **任何类型（包括基本数据类型）都具备一个隐藏的静态的class属性**

   ```java
   Class c2 = Person.class
   ```

   ​

3. **Class类的静态方法forName()-->推荐使用**

   ```java
   Class c3 = Class.forName("com.itheima.bean.Person")
   ```

   > **需要写类的全名** 

* **class对象的相关方法**


1. ```java
   String getSimpleName(); 获得简单类名，只是类名，没有包		
   ```

2. ```java
   String getName(); 获取完整类名，包含包名+类名	
   ```

3. ```java
   T newInstance() ;创建此 Class 对象所表示的类的一个新实例。要求：类必须有public的无参数构造方法
   ```


```java
			String name = c.getName();  // 输出 Day13.Demo_GetClass.Person
			String simpleName = c.getSimpleName(); // 输出  Person
			System.out.println(name);
			System.out.println(simpleName);
```



### 2.3 反射获取构造方法

获取字节码文件的对象并获取空参构造方法并运行（创建对象）

**Class类的方法 getConstructors()**

* `Constructor[] getConstructors()`获取所有共有（public）权限的构造方法

* `Constructor getConstructor()`  获取空参构造方法

* `Constructor getConstructor(Class ... type)`获取带参的构造方法

  ​	class ... type Class类型的可变参数

  ​	不传参数-->获取空参构造方法

  ​	如果传参，需要传构造函数的参数的类型

  ​	如public Person(String name, int age)

  ​		`getConstructor(Sting.class,int.class)`

**运行构造方法**

​	Constructor类的方法

* `Object newInstance（）`运行空参构造，常见对象

* `Object newInstance(Object ... args)`运行带参构造方法

  ​	Object ... args 调用构造方法需要传入的实际参数

**暴力反射**-不推荐使用破坏了类的封装性

获取私有的构造方法并运行

`Constructor  getDeclaredConstructors() ` 获取所有的方法，包括私有方法

**快捷方式创建对象**

前提：类必须有空参构造函数，空参构造是public的

1. 获取字节码对象

2. 通过字节码文件创建对象

   `Object newInstance()` 

### 2.4 反射获取get/set方法并运行(重要)

1. 获取字节码文件对象

2. 获取方法

   class类的方法

   ​	`Method [] getMethods()`获取所有的公共的方法，包括继承的方法

   ​	`Method  getMethod(String name,class ... type) `获取指定方法，需要指定方法名和参数列表

3. 运行方法

   ​	Method类的方法

   ​	`Object invoke(Object obj, Object ... args)`

   ​	返回值为Object->是调用方法的返回值，没有返回值，返回null

   ​	参数：

   ​	Object obj：运行方法需要对象，需要传入对象，可以利用反射快捷方式获得


```java
// 方法使用实例
package Day13.Demo_GetClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Get_Class {
    public static void main(String[] args) throws Exception {
        // 第一种方法 获取字节码文件
        Class  c = Class.forName("Day13.Demo_GetClass.Person");
        // Class c2 = Class.forName("Person"); // 错误.应该写全类名
        System.out.println(c);

        // 第二种方法 获取字节码文件
        Class  c2 = Person.class;
        System.out.println(c2);

        // 第三种方法 获取字节码文件
        Person p = new Person();
        Class c3 = p.getClass();
        System.out.println(c3);

        // Class类的获取方法
        String name = c.getName();
        String simpleName = c.getSimpleName();
        System.out.println(name);
        System.out.println(simpleName);

        // 获取空参构造函数
        Constructor con = c.getConstructor();
        System.out.println(con);
        // 获取带参构造函数
        Constructor con2 = c.getConstructor(String.class,int.class);
        System.out.println(con2);
        // 获取所有public权限的构造函数
        Constructor[] con3 = c.getConstructors();
        for(Constructor cons:con3 ){
            System.out.println(cons);
        }
        System.out.println("-------------");
        // 使用获得的构造函数创建对象
        Object newInstance = con2.newInstance("周杰伦", 40);
        System.out.println(newInstance);//输出 Person{name='周杰伦', age=40}
        // 获取所有方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("------------");
        // 获取指定空参方法
        Method getAge = c.getMethod("getAge");
        System.out.println(getAge);
        System.out.println("++++++++++++++");
        // 获取指定带参方法
        Method setAge = c.getMethod("setAge", int.class);
        System.out.println(setAge);
        // 快捷方式创建对象
        Object o = c.newInstance();
        System.out.println("------------");
        // 运行指定方法
        Object o1 = setAge.invoke(o, 20);
        System.out.println(o1);
        System.out.println(o);
    }
}


// Person 类
package Day13.Demo_GetClass;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println("姓名: " + name + " 年龄: " + age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(this.getClass() == obj.getClass()) || obj == null) {
            return false;
        }
        Person p1 = (Person) obj;
        return p1.age == this.age &&
                p1.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```



## 3. 注解

* 注解： 也叫元数据 说明程序 给虚拟机看
* 注释 ：给程序员看

注解与类 接口 枚举是同一个层次

**作用**

1. 帮助文档-->Javadoc
2. 代码分析-->使用反射-框架时使用
3. 编译检查-->Override

### 3.1 自定义注解（重要）

定义注解的关键字  @interface

格式 

空注解

`public @interface 注解名{}` 

有属性的注解

注解的格式:

```java
 public @interface 注解名{
   		//属性
   修饰符  数据类型 属性名() [default 属性值];
   // 修饰符 public abstract 固定写法，不写默认也是public abstract
   // 数据类型 基本类型 String  Class类 枚举类型，其他注解类型 以及以上类型的一维数组
 }
```

注解使用例子:

```java
public @interface MyAnnotation{
   public abstract String name();// 字符串
   public abstract int age default 38；// int类型
   public abstract MyAnnotation my();//注解类型
  public abstract Class c();//Class类型
  public abstract String[] name();//String类型数组
}
```



### 3.2 注解使用

1. **如果为空注解，直接使用即可**
2. **同一个对象上，同一个注解只能使用一次，但同一个对象，可以使用多个不同的注解。**
3. **如果是有属性的注解，必须要给属性赋值才能使用。在小括号中，以键值对的方式赋值--->属性名=属性值 多个属性以“，”隔开，如果属性是数组类型，数组中只有一个值时，可以省略{}，否则要用{}进行赋值。**
4. **特殊的属性名 value 如果一个注解只有一个属性，并且属性的名称为value使用时可以省略属性名value**
5. **如果这个属性有默认值，可以不赋值，如果没有默认值，必须赋值**

### 3.3 元注解

使用来修饰自定义注解的注解

**作用**

1. 指定注解的生命周期

2. 指定注解的使用位置

3. 一个自定义注解，必须由元注解修饰后才能使用

   ​

**@Target**

指定注解使用的**位置**

1. **TYPE** 使用在类 接口

2. **FIELD**  使用在成员变量

3. **METHOD** 使用在方法上

4. **CONSTRUCTIONOR** 使用在构造方法上

   ```java
   @Target(ElementType.METHOD)
   ```

   ​

**@Retention**

定义注解的**生命周期** 不指定，默认为CLASS

1. **SOURCE** 注解仅在源代码中，编译后的文件不存在

2. **CLASS**  注解存在于源代码，编译后的文件，运行的代码不存在

3. **RUNTIME** 注解存在于 源代码 编译后的class文件（字节码文件） 运行内存中，程序可以通过反射获取该注解。

   ```java
   @Retention(RetentionPolicy.RUNTIME)
   ```

   ​

### 3.4 注解的解析

获取注解中属性值

AnnotatedElement类中的方法

* `boolean isAnnotationPresent(Class annotationClass)` 判断当前对象是否有指定的注解，有则返回true，否则返回false。
* `T getAnnotation(Class<T> annotationClass); `  获得当前对象上指定的注解对象。
* `Annotation[] getAnnotations(); ` 获得当前对象及其从父类上继承的所有的注解对象。
* `Annotation[] getDeclaredAnnotations();` 获得当前对象上所有的注解对象，不包括父类的。

示例



```java
// 自定义注解
package Day13.Annotation_Demo2;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mytest2 {
}

```

```java
//  使用注解类
package Day13.Annotation_Demo2;

public class Annotation_Demo2 {

    @Mytest2
    public void method(){
        System.out.println("method is running");
    }
    @Mytest2
    public void method1(){
        System.out.println("method1 is running");
    }
    public void method2(){
        System.out.println("method2 is running");
    }
    public void method3(){
        System.out.println("method3 is running");
    }
    @Mytest2
    public void method4(){
        System.out.println("method4 is running");
    }

}
```

```java
// 测试类
package Day13.Annotation_Demo2;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        // 获取字节码对对象
        Class demo2 = Class.forName("Day13.Annotation_Demo2.Annotation_Demo2");
        // 获取所有方法
        Method[] methods = demo2.getMethods();
        // 遍历所有方法,获取由注解的方法
        Object o = demo2.newInstance();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Mytest2.class)){
                // 如果有注解,运行方法
                method.invoke(o);
            }
        }
    }
}
// 输出为
//method is running
//method1 is running
//method4 is running

```

