# Mybatis简介  
## 1.什么是 MyBatis?  
MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。  
MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis   
可以通过简单的 XML 或注解来配置和映射原始类型、接口和   
Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

## 2.第一个Mybatis程序
思路：环境搭建-->导入Mybatis-->编写代码-->测试  

### 2.1.环境搭建
- 创个表
```sql
CREATE TABLE `user`(
	`id` INT(10) PRIMARY KEY,
	`name` VARCHAR(20) DEFAULT NULL,
	`pwd` VARCHAR(30) DEFAULT NULL)
	ENGINE=INNODB DEFAULT CHARSET=utf8;
```
