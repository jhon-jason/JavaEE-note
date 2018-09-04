## 1.1 JDBC 预处理对象

* 使用**Statement**执行sql语句需要拼接字符串, 存在SQL注入攻击的问题
* 使用**Statement** 的子类: **PreparedStatement**-->预编译SQL语句对象
* **PreparedStatement** **效率高**于Statement 而且**可以防止注入攻击**

Connection的静态方法

```java
// 格式
PreparedStatement prepareStatement(String sql)
// 实例  
  PreparedStstement ps = con.prepareStatement(sql)
  // con 为获取的连接对象  sql 为需要执行的sql语句
```

需要传入的内容写 ?

为 SQL语句中 ? 赋值的方法

```java
setObject( int 第几个问号, 问号的值)
  // 实例
  setObject(1,"jack");  // 将sql语句中的第一个问号的值替换为jack
```



```java
String sql = "SELECT * FROM users WHERE username = ? AND password = ? ";
PreparedStatement ps = con.PreparedStatement(String sql);
ps.setObject(1,admin);
ps.setObject(1,admin);
// 执行sql 语句
ps.executeQuery(); // 执行查询
ps.executeUpdate(); // 执行增删改
// 处理结果
// 关闭资源

```

## 2. 连接池

* 优化连接,避免来连接的反复创建和销毁

### 2.1 数据源规范

java 中 数据库的连接池的公共接口为 **javax.sql.DataSource** 

常见连接池: **C3P0**  DBCP

### 2.2 常用数据连接池配置

#### 2.2.1  C3P0

* C3P0 实现 **javax.sql.DataSource**  的方法,可以使用DataSource的方法

  ```java
  Connection getConnection() 
    // 从连接池中获得来连接
    // C3P0 中的ComboPoolDataSource 实现了Datasorce接口,创建这个类的对象,调用方法
  ```

* C3P0工具类

  ```java
  public class JdbcUtils {
      //创建一个C3P0的连接池对象（使用c3p0-config.xml中default-config标签中对应的参数）
      public static DataSource ds = new ComboPooledDataSource();

      //从池中获得一个连接
      public static Connection getConnection() throws SQLException {
          return ds.getConnection();
      }

      //释放资源
      public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
          if (rs != null) {
              try {
                  rs.close();
              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
              rs = null;
          }
          if (stmt != null) {
              try {
                  stmt.close();
              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
              stmt = null;
          }
          if (conn != null) {
              try {
                  conn.close();
              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
              conn = null;
          }
      }
  }
  ```

  ​



## 3. DBUtils 

* 简化JDBC的开发代码

* 掌握三个核心功能

  1. **QueryRunner**  类 执行sql语句
  2. **ResultSetHandler** 接口  处理结果
  3.  **DbUtils** 类 关闭资源 事务处理

  ### 3.1 使用类: **QueryRunner**  类

  **构造方法** :

  1. `public QueryRunner()`

     使用空参构造,需要自己获取和关闭连接,,

  2. `public QueryRunner(DataSouce ds)`

     使用带参构造,需要传入连接池对象,之后的连接问题(获取,关闭),不需要我们处理

  **方法** 

  * 增删改 **update**

  1. `int update(Connection con , String sql ,Object ... args)` 
     * 使用第一种构造方法创建对象
     * Connection  con 为需要传入的连接对象
     * String sql  为需要执行的sql语句,支持带有?的形式
     * Object ... args  给问号赋值
  2. `int update(String sql ,Object ... args)` 
     * 不需要传入连接对象(使用带参构造)

     * String sql  为需要执行的sql语句,支持带有?的形式

     * Object ... args  给问号赋值

       ​

  * 查询 **query**

  1.  `query(Connection con , ResultSetHandler re ,sql, Object ... args)` 

  2.  `query( ResultSetHandler re ,sql, Object ... args)` 

     * ResultSetHandler re: 结果集处理的结果,是接口 ,传入实现类对象

       ​

     | 结果处理                  | 说明                                       |
     | :-------------------- | :--------------------------------------- |
     | **ArrayHandler**      | 将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值 |
     | ArrayListHandler      | 将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。 |
     | **BeanHandler**       | 将结果集中第一条记录封装到一个指定的javaBean中。             |
     | **BeanListHandler**   | 将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中 |
     | **ColumnListHandler** | 将结果集中指定的列的字段值，封装到一个List集合中               |
     | KeyedHandler          | 将结果集中每一条记录封装到`Map<String,Object>` ,在将这个map集合做为另一个Map的value,另一个Map集合的key是指定的字段的值。 |
     | MapHandler            | 将结果集中第一条记录封装到了`Map<String,Object>` 集合中，key就是字段名称，value就是字段值 |
     | MapListHandler        | 将结果集中每一条记录封装到了`Map<String,Object>` 集合中，key就是字段名称，value就是字段值，在将这些Map封装到List集合中。 |
     | **ScalarHandler**     | 它是用于单个数据。例如select  count(*) from 表操作。    |




1. BeanHandler

   * 构造方法
     * BeanHandler(Class c)

2. BeanListHandler

   * 构造方法
     - BeanListHandler(Class c)

3. ColumnListHandler

   * 将指定列的数据,放到list集合中


   * 构造方法
     * ColumnListHandler(String name)
       * String name 需要查询的列名 

4. ScalarHandler

   - 获取单个数据


   - 构造方法
     - ScalarHandler()  
       - 查询结果只有一个时使用空参构造
     - ScalarHandler(String name)
       - 查询的结果为多个, 指定需要获取的列名

