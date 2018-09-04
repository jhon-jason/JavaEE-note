## 1. 多表查询

#### 1.1 交叉查询 -- 一般不用

```mysql
SELECT * FROM A,B;
```

> 交叉查询,结果数据可能错误
>
> 所谓交叉查询,就是用一张表的每条记录和两一张每条记录进行拼接.



#### 1.2  内连接

##### 	1.2.1  隐式内连接

```mysql
-- 语法
select * from A,B where 条件;
```

```mysql
-- 实例
SELECT * FROM categroy,products WHERE categroy.cid = product.categroy_id;
```

##### 	1.2.2  显式内连接

```MYSQL
-- 语法
A [inner] join B on 条件
```

```mysql
-- 实例
SELECT * FROM categroy INNER JOIN product ON categroy.cid = product.category_id ;
```

#### 1.3  外连接

##### 	1.3.1 左外连接

```mysql
A left join b on 条件
```

##### 	1.3.2 右外连接

```mysql
A right join B on 条件
```

* 内连接 查询公共部分,是两张表的交集
* 左外连接,以左表有的数据做基础,全部查询,如果左表有的元素,右表没有没有,则为null

#### 1.4 子查询

* 一条语句的查询结果,作为另一条语句的**查询条件**

  ​

  * 查询结果作为**伪表**

  ```mysql
  SELECT * FROM 
  	(SELECT * FROM category WHERE cname ='化妆品' OR cname = '服饰') c,
  	products p WHERE c.cid = p.category_id;
  ```

  ​

  * 查询结果作为**条件**

  ```mysql
  SELECT * FROM products WHERE category_id IN 
  	(SELECT cid FROM category  WHERE cname='化妆品' OR cname = '服饰');
  ```

  ​

**数据库查询基本顺序**  **重要** 

```mysql
SELECT 字段(聚合函数) FROM 表名 WHERE 条件 GROUP BY 字段 HAVING 条件(运算) ORDER BY 字段 LIMIT
```





## 2. JDBC

* JDBC----->JDBC是Java访问数据 库的标准规范，可以为不同的关系型数据库提供统一访问，它由一组用Java语言编写的接口和类组成。 

环境准备:  导入mysql 驱动jar包

开发步骤:(固定写法 除了执行的SQL语句不同)

1. **注册驱动 **  ` Class.forName("com.mysql.jdbc.Driver");` 
2. **获得连接**   ` Connection con = DriverManager.getConnection(url, user, password);` 
3. **获得执行对象**  ` Statement stat = con.createStatement(); ` 
4. **执行语句,返回结果**   ` ResultSet rs = stat.executeQuery(sql);` 
5. **处理结果**   查询需要处理,增删改返回为Int 类型影响行数
6. **释放资源**  一堆close

```java
public class Demo02_JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/day16";
        String user = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, user, password);
        //获取执行sql语句的对象
        Statement stat = con.createStatement()
        String sql = "select cname,cid from category";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()){

            String cid = rs.getString("cid");
            String cname = rs.getString("cname");
            System.out.println(cid + " "+cname);
        }
        rs.close();
        stat.close();
        con.close();
    }
}

```



