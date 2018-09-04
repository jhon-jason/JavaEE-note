# MySQL

## 1. 数据库概述

* 数据按照特定格式存储数据的仓库
* DBMS 数据库管理系统-->用户通过DBMS访问数据库中数据

### 1.1 常见数据库

* **MYSQL** 开源免费
* **Oracle** 收费大型数据库
* DB2 IBM收费数据库 应用于银行系统

### 1.2 数据库表

| java程序 |  数据库   |
| :----: | :----: |
|   类名   |   表名   |
|  成员变量  | 列名(表头) |
| 一个实例对象 |  一条记录  |

## 2.  SQL 语句

结构化查询语言简称SQL(Structured Query Language)

### 2.1  SQL通用语法

* 可以单行或多行书写,以分号结尾, 
* 可以使用空格和缩进来增加语句可读性
* MySQL语句不区分大小写,关键字建议大写
* /**/ 为注释  -- 为单行注释(--后必须有空格) # 单行注释

###  2.2 创建 / 删除 / 切换 数据库

```mysql
-- 创建数据库
CREATE DATABASE 数据库名;
-- 删除数据库
DROP DATABASE 数据库名;
-- 切换数据库
USE 数据库名;
```

### 2.3  创建表

* 创建表 格式

  ```mysql
  CREATE TABLE 表名(
  		列名 数据类型(长度) [约束],
    	 列名 数据类型(长度) [约束],
      列名 数据类型(长度) [约束]
  );
  ```

  ```mysql
  # 例如:
  CREATE TABLE users(
    -- 主键自动增长
  	uid INT PRIMARY KEY AUTO_INCREMENT, 
    uname VARCHAR(20),
    age INT
  );
  ```

  **约束是用来限制当前列的数据** 比如是否唯一,是否可以为null

  ​	**主键约束** `PRIMARY KEY` 限制当前列数据 非空 唯一



### 2.3  查看表

- 查看当前目录所有的表

  ```mysql
  SHOW TABLES;
  ```

- 查看表结构

  ```mysq
  DESC 表名;
  ```

- 删除表

  ```mysql
  DROP TABLE 表名;
  ```

- 修改表

  ```mysql
  /* 添加列 */
  ALTER TABLE 表名 ADD 列名 数据类型(长度) [约束];
  /* 修改列  - 数据类型 约束*/
  ALTER TABLE 表名 MODIFY 列名 数据类型(长度) [约束];
  /* 修改列  - 列名 数据类型 约束*/
  ALTER TABLE 表名 CHANGE 旧列名 新列名 数据类型(长度) [约束];
  /* 删除列 */
  ALTER TABLE 表名 DROP 列名;
  ```

- 修改表名

  ```mysql
  RENAME TABLE 旧表名 TO 新表名;
  ```

  ​

### 2.4 添加数据

* 添加数据

  ```mysql
  INSERT INTO 表名(列名1,列名2...) VALUE (值1, 值2...);
  ```

  数据库中,除了整数小数,其余类型数据必须使用 "  " 或  '  '包裹,推荐使用单引号 '  '  -->放入java中不易出错

* 全列值方式添加

  ```mysql
  INSERT INTO 表名 VALUE (全列值);
  ```

  全列值必须全部列值都要写,包括自增的主键值,

  例如

  ```mysql
  INSERT INTO users VALUE (null,'周杰伦',40);
  -- null 为主键值位置
  ```

* 批量添加

  ```mysql
  INSERT INTO 表名(列名1,列名2...) VALUE (值1, 值2...),(值1, 值2...),(值1, 值2...),(值1, 值2...);
  ```

  ​

### 2.5 修改表结构

* 修改表结构

  ```mysql
  UPDATE 表名 SET 列名=列值,列名=列值...WHERE 条件;
  -- 如果不写 WHERE 会将表中所有数据都更改
  ```

  ```mysql
  #将金莲的年龄改为100
  UPDATE users SET age = 100 WHERE uname = '金莲';
  # 将age 不等于30的年龄改为100
  UPDATE users SET age = 100 WHERE age <> 30;
  ```

| Java | MySQL    |
| ---- | -------- |
| >    | >        |
| <    | <        |
| ==   | =        |
| >=   | >=       |
| <=   | <=       |
| !=   | <> 或者 != |
| &&   | AND      |
| \|\| | OR       |
| !    | NOT      |

  ### 2.6  删除表记录

* 删除表记录

  ```mysql
  DELETE FROM 表名 WHERE 条件;
  ```

  ```mysql
  # 删除表中uid为10的记录
  DELETE FROM users WHERE uid=10;
  ```

* 删除表记录

  ```mysql
  TRUNCATE TABLE users;
  # 这个是DDL语言 摧毁表 重新创建一张一模一样的表
  # 会将自动增长从1开始(清除之前记录)
  ```




* 解决windows命令行乱码

  \> `set names gbk;` 临时改变表的编码,关闭命令行窗口恢复,不影响数据库编码

## 3. SQL 约束

### 3.1 主键约束 PRIMARY KEY

* 主键列必须为唯一值
* 主键列不能包含null值
* 每个表都应该有且仅有一个主键列
* 主键列应与业务逻辑无关的列,一般为ID列

####3.11 主键类添加方式

1.  在定义表时直接在列后添加

   ```mysql
   -- 实例
   CREATE TABLE person(
   	pid INT PRIMARY KEY,
     lastname VARCHAR(255),
     firstname VARCHAR(255)
   );
   ```

   ​

2. 在创建表时,在constraint区域添加,格式为

   ```mysql
   CONSTRAINT 主键名 PRIMARY KEY (列名)

   -- 实例
   CREATE TABLE person(
   	pid INT,
     lastname VARCHAR(255),
     firstname VARCHAR(255),
     CONSTRAINT pk_pid PRIMARY KEY (pid)  
   );
   ```

   ​

3. 在创建表结束后,使用修改表结构方式添加,格式如下

   ```mysql
    ALTER TABLE Persons ADD [CONSTRAINT 名称] PRIMARY KEY (字段列表)
   ```

   ```mysql
   -- 实例
   ALTER TABLE persons ADD CONSTRAINT pk_pid PRIMARY KEY (pid);
   ```

   ​

#### 3.1.2 联合主键

​	将两个列作为一个主键,两列的数据不可以完全相同,有一列相同,可以存入.

​	格式:

```mysql
CONSTRAINT pk_name PRIMARY KEY (lastname,firstname)
```

#### 3.1.3 删除主键(了解)

格式

```mysql
ALTER TABLE Persons DROP PRIMARY KEY
```

如果主键设置为自动增长,则不能直接删除主键,需要先取消主键的自动增长,再删除主键



### 3.2 非空约束

​	限制当前列的值不能为null-->不能不写入数据 "" 和"null"可以null不行

​	一个表中只能有一个主键,可以有多个非空约束

​	**非空约束**  `NOT NULL`

```mysql
CREATE TABLE person(
	pid INT,
  lastname VARCHAR(255) NOT NULL,
  firstname VARCHAR(255),
);
```

* 修改表结构方式 增加非空约束

  ```mysql
  ALTER TABLE 表名 MODIFY 列名 数据类型(长度) [约束]
  ```

  ```mysql
  -- 实例
  ALTER TABLE persons MODIFY address VARCHAR(255) NOT NULL;
  ```

  ​

### 3.3  唯一约束 UNIQUE

​	一个表中可以有多个唯一约束

#### 3.3.1 添加方式 

* 方式1  创建表直接在列后添加

  ```mysql
  CREATE TABLE persons
  (
  	id_p INT PRIMARY KEY AUTO_INCREMENT,
  	lastname VARCHAR(255) NOT NULL,
  	firstname VARCHAR(255),
  	address VARCHAR(255) UNIQUE, -- 唯一约束
  	city VARCHAR(255)
  )
  ```

  ​

* 方式2  创建表在约束区域 ,声明唯一

  ```mysql
  CREATE TABLE persons
  (
  	id_p INT,
  	lastname VARCHAR(255) NOT NULL,
  	firstname VARCHAR(255),
  	address VARCHAR(255),
  	city VARCHAR(255),
  	CONSTRAINT u_id UNIQUE (Id_P)
  )
  ```

  ​

* 方式3  创建表后 修改表结构方式添加

  ```mysql
  CREATE TABLE persons
  (
  	id_p INT PRIMARY KEY AUTO_INCREMENT,
  	lastname VARCHAR(255) NOT NULL,
  	firstname VARCHAR(255),
  	address VARCHAR(255),
  	city VARCHAR(255),
  	CONSTRAINT u_address UNIQUE (address)
  )
  ```

  ​

#### 3.3.2  删除唯一约束

```mysql
ALTER TABLE 表名 DROP 名称
-- 名称为自定以的名称,未定义为默认字段的名
-- 实例
ALTER TABLE persons DROP INDEX u_address;
```

