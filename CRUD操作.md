# CRUD操作
- namespace  
```bash
用于绑定mapper.xml和对应接口
```
- select
- insert
- update
- delete

**注意增删改需要提交事务**  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mildlamb.dao.UserDao">
    <select id="getUserList" resultType="com.mildlamb.pojo.User">
        select * from mybatis.user;
    </select>

    <select id="getUserByName" resultType="com.mildlamb.pojo.User" parameterType="String">
        select * from mybatis.user where name = #{name};
    </select>

    <!-- 对象中的属性可以直接取出来 -->
    <insert id="addUser" parameterType="com.mildlamb.pojo.User">
        insert into mybatis.user(id,name,pwd) values(#{id},#{name},#{pwd});
    </insert>

    <update id="updateUser" parameterType="com.mildlamb.pojo.User">
        update mybatis.user set name = #{name},pwd = #{pwd} where id = #{id};
    </update>

    <delete id="delUser" parameterType="integer">
        delete from mybatis.user where id = #{id};
    </delete>
</mapper>
```

### 万能的Map集合
假设，我们实体类或者数据库中的表，字段或者参数过多，但又不需要用到全部，可以考虑使用Map集合作为参数  
```java
int updateUser2(Map<String,Object> map);
```
```xml
<!-- 使用map集合#{}中使用map的key即可 -->
<update id="updateUser2" parameterType="map">
update mybatis.user set name = #{username},pwd = #{password} where id = #{uid};
</update>
```
```java
@Test
    public void test6(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","QSJ");
        map.put("uid",4);
        mapper.updateUser2(map);
    }
```

### 模糊查询
- Java代码执行的时候传递%
```java
@Test
    public void test7(){
        List<User> kind = mapper.getUserLike("%kind%");
        for (User user : kind) {
            System.out.println(user);
        }
        sqlSession.close();
    }
```
- 在sql拼接中使用通配符
```xml
<select id="getUserLike" parameterType="String" resultType="com.mildlamb.pojo.User">
        select * from mybatis.user where name like "%"#{name}"%"
</select>
```
