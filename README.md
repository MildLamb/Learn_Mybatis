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
- 创建新项目，删除src作为父项目
- 导入依赖
```xml
<dependencies>
<!-- mysql驱动 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.46</version>
</dependency>
<!-- mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.2</version>
</dependency>
<!-- junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
</dependencies>
```

- 创建模块
- 编写Mybatis核心配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- mybatis核心配置文件 -->
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="W2kindred"/>
            </dataSource>
        </environment>
    </environments>
</configuration>
```
