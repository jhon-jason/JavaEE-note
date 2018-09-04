# 1. SQL 语句-- DQL

## 1.1 简单查询

1. 查询所有数据

   ```mysql
   SELECT * FROM 表名;
   ```

2. 查询指定列

   ```mysql
   SELECT 列名,列名 ...  FROM 表名;
   ```

3. 去掉重复数据 DISTINCT

   ```mysql
   SELECT DISTINCT 列名 FROM 表名;
   ```

4. 别名查询   --仅在查询结果中显示,数据库中的列名不变化

   ```mysql
   列名 AS '别名';
   ```

   ```mysql
   SELECT pname AS '商品名称' FROM product;
   ```

   * > 其中 as可以省略

     ```mysql
     SELECT pname  '商品名称' FROM product;
     ```

   * > 单引号可以省略 但是名称中不可以有空格

     ```mysql
     SELECT pname  商品名称 FROM product;
     ```

5. 查询中 做计算

   ```mysql
   SELECT pname , price+100 FROM product;
   ```



## 1.2 条件查询 模糊查询

| 类别    | 符号                      | 作用                         |
| :---- | ----------------------- | -------------------------- |
| 比较运算符 | < , > , <=, >= , = , <> | 小于, 大于, 小于等于,大于等于,等于,不等于   |
|       | BETWEEN  ...AND...      | 显示在某一区间的值 (含头含尾)           |
|       | IN (set)                | 显示在IN 列表中的值                |
|       | LIKE 'pattern'          | 模糊查询  % 任意个字符(包括0个)  _一个字符 |
|       | IS NULL                 | 判断是否为空                     |
| 逻辑运算  | AND                     | 多个条件同时成立                   |
|       | OR                      | 多个条件任一成立                   |
|       | NOT                     | 不成立                        |

```mysql
-- 查询商品名称为花花公子的商品的所有信息
SELECT * FROM product where pname = '花花公子';

-- 查询价格为800的商品
SELECT * FROM product WHERE price = 800;

-- 查询所有价格不是800的商品
SELECT * FROM product WHERE price != 800;
SELECT * FROM product WHERE price <> 800;
SELECT * FROM product WHERE NOT( price = 800);

-- 查询价格大于60的所有商品信息
SELECT * FROM product WHERE price > 60;

-- 查询所有价格在200到1000之间的商品信息
SELECT * FROM product WHERE price >= 200 AND price <= 1000;
SELECT * FROM product WHERE NOT (price <200 or price >1000);
SELECT * FROM product WHERE price BETWEEN 200 and 1000;
 
-- 查询所有价格是200 或是 800 的商品信息
SELECT * FROM product WHERE price = 200 or price = 800;
SELECT * FROM product WHERE price IN (200,800);

-- 查询所有含有 霸  字的商品
SELECT * FROM product WHERE pname LIKE'%霸%';

-- 查询所有以香 字开头的商品
SELECT * FROM product WHERE pname LIKE'香%';

-- 查询所有第二个字为 想的商品
SELECT * FROM product WHERE pname LIKE'_想%';

-- 没有商品分类的商品 (非空查询)
SELECT * FROM product WHERE category_id IS NULL;

-- 查询所有商品分类的商品(非空查询)
SELECT * FROM product WHERE NOT( category_id IS NULL);
SELECT * FROM product WHERE category_id IS NOT NULL;
```

## 1.3 排序 ORDER BY

格式

```mysql
ORDER BY 列名 DESC/ASC;
DESC 降序  ASC 升序排序(默认)可以不写
```

- 排序都是写在查询的最后, 对结果进行排序

  ```mysql
  -- 使用价格排序 - 降序
  SELECT * FROM product ORDER BY price DESC;
  -- 在价格排序的基础上 以分类排序
  SELECT * FROM product ORDER BY price DESC,category_id DESC;
  -- 显示商品价格 (去重复) 并降序排序
  SELECT DISTINCT price FROM product ORDER BY price DESC;
  -- 忽略空值 价格排序的
  SELECT * FROM product WHERE price IS NOT NULL ORDER BY price DESC;
  ```

  ​

## 1.4 聚合查询

* 聚合查询----聚合函数 一般忽略null值

  1. ```mysql 
     COUNT(expr)  计数
     ```

  2. ```mysql
     SUM(expr)   求和
     ```

  3. ```mysql
     MAX(expr)    最大值 
     ```

  4. ```mysql
     MIN(expr)   最小值
     ```

  5. ```mysql
     AVG([DISTINCT] expr) 平均值
     ```

```mysql
-- 聚合查询

-- COUNT(expr)
-- SUM(expr)
-- MAX(expr)
-- MIN(expr)
-- AVG([DISTINCT] expr)

-- 查询商品的总条数
SELECT COUNT(*) FROM product;
-- 查询价格大于200的商品的总条数
SELECT COUNT(price > 200) FROM product;
-- 查询分类为 c001 的所有商品的总和
SELECT SUM(category_id = 'c001') FROM product;
-- 查询分类为 c002 的商品的平均价格
SELECT AVG(category_id = 'c002' ) FROM product;
```



## 1.5 分组查询  GROUP BY

* 对哪一列分组 **就是将这一列重复的数据作为一组,**不重复的自己为一组.
* 分组函数不可以单独使用,都是与聚合函数结合使用
* 对哪列分组 最好同时查询出来 --- 方便查看

```MYSQL
GROUP BY 列名;
```

​	`WHERE`和`HAVING`区别

​	`WHERE 过滤条件`   是在查询前进行过滤,不能给查询结果进行过滤 , where后不可以跟聚合函数

​	`HAVING 过滤条件 `  是在查询后对查询结果进行过滤,having后可以跟聚合函数.



```mysql
-- 分组查询 GROUP BY
--  格式
SELECT 字段1, 字段2,... FROM 表名 GROUP BY 分组字段 HAVING 分组条件;

-- 统计 各个分类的商品个数
SELECT category_id, COUNT(*) FROM product GROUP BY category_id;
-- 统计各个分类的商品个数 且仅显示个数大于1 的信息
SELECT category_id, COUNT(*) FROM product GROUP BY category_id HAVING COUNT(*)>1;
```



#2. 数据库备份

###2.1 MySQL 命令备份与恢复

* 备份命令

  ```
  mysqldump  ‐u用户名 ‐p密码 数据库名>生成的脚本文件路径
  例如
  mysqldump  ‐uroot  ‐proot day04>d:\day03.sql
  ```

* 恢复命令

  * 数据库外

    ```
     mysql  -uroot  -p密码 数据库名 < 文件路径 
     例如  mysql  -uroot  -proot day03<d:\day03.sql 
    ```

  * 数据库内

    ```mysql
    source SQL脚本路径
    -- 例如   
    source d:\day03.sql 
    ```

    ​

  ​

###2.2 图形化工具备份与恢复



# 3. 多表操作

## 3.1 多表关系 

* 一对多和多对一
* 多对多
  * 多对多需要有中间表

**主表中主键有的数据 从表中的外键可以没有**

**但是主表中主键没有的数据,从表外键中不可以存在**

**添加外键约束**

```mysql
ALTER TABLE 从表名 ADD [CONSTRAINT 外键名] FOREIGN KEY (从表 外键列名) REFERENCES 主表名(主键列名)
```

```mysql

-- 创建订单表
CREATE TABLE orders(
	oid INT PRIMARY KEY AUTO_INCREMENT,
	totalprice DOUBLE
);
-- 创建中间表
CREATE TABLE ord_pros(
	pid INT,
	oid INT
);
-- 将product 的 pid 设为主键
ALTER TABLE product ADD PRIMARY KEY(pid);
-- 建立订单与中间表的关系
ALTER TABLE ord_pros ADD FOREIGN KEY ord_pros(oid)
REFERENCES orders(oid);
-- 定义产品与中间表的外键
ALTER TABLE ord_pros ADD CONSTRAINT fk_pid FOREIGN KEY(pid) REFERENCES product(pid);

```



