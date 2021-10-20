# 动态SQL
### 搭建环境
- 编写数据表
```sql
CREATE TABLE `blog`(
	`id` VARCHAR(20) PRIMARY KEY,
	`title` VARCHAR(30) NOT NULL COMMENT '博客标题',
	`author` VARCHAR(20) NOT NULL COMMENT '博客作者',
	`create_time` DATETIME NOT NULL COMMENT '创建时间',
	`views` INT(20) NOT NULL COMMENT '浏览量'
	)ENGINE=INNODB DEFAULT CHARSET=utf8;
```
- 创建一个基础工程
  1. 导包
  2. 编写配置文件
  3. 编写实体类
  4. 编写实体类对应的Mapper接口和Mapper.xml文件

## IF
- 接口
```java
List<Blog> queryBlogIf(Map map);
```

- mapper.xml
```xml
<select id="queryBlogIf" resultType="blog" parameterType="map">
    select * from blog where 1 = 1
    <if test="tit != null">
        and title = #{tit}
    </if>
    <if test="author != null">
        and author = #{author}
    </if>
</select>
```
- 测试类
```java
@Test
public void test2(){
    Map<String,String> map = new HashMap<String, String>();
    map.put("tit","生命就是我们");
    List<Blog> blogs = blogMapper.queryBlogIf(map);
    for (Blog blog : blogs) {
        System.out.println(blog);
    }
    sqlSession.close();
}
```
