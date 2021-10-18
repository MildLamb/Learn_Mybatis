# 解决属性名和字段名不一致的问题
- poko
  - id
  - username
  - password

- 数据库
  - id
  - name
  - pwd

解决方法：
- 起别名
```xml
<select id="getUserByName" resultType="com.mildlamb.pojo.User" parameterType="String">
    select id,name as username,pwd as password from mybatis.user where name = #{name};
</select>
```
- resultMap
```xml
<resultMap id="UserMap" type="com.mildlamb.pojo.User">
    <!-- column对应数据库中的字段，property对应实体类字段 -->
    <result property="id" column="id"></result>
    <result property="username" column="name"></result>
    <result property="password" column="pwd"></result>
</resultMap>

<select id="getUserByName" parameterType="String" resultMap="UserMap">
    select * from mybatis.user where name = #{name};
</select>
```
