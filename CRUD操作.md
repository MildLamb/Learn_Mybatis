# CRUD操作
- namespace  
```bash
用于绑定mapper.xml和对应接口
```
- select
- insert
- update
- delete

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
