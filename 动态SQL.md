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

## choose、when、otherwise
choose、when、otherwise类似于java的switch、case，只会有一个生效
- 接口
```java
List<Blog> queryBlogChoose(Map<String,String> map);
```
- mapper.xml
```xml
<select id="queryBlogChoose" resultType="blog" parameterType="map">
select * from blog
<where>
    <choose>
	<when test="tit != null">
	    title = #{tit}
	</when>
	<when test="author != null">
	    and author = #{author}
	</when>
	<otherwise>
	    and views > #{views}
	</otherwise>
    </choose>
</where>
</select>
```
- 测试类
```java
@Test
    public void test3(){
        Map<String,String> map = new HashMap<String, String>();
//        map.put("tit","生命就是我们");
        map.put("author","纳尔");
        map.put("views","900");
        List<Blog> blogs = blogMapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
```


## trim、where、set
- where | where 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。而且，若子句的开头为 “AND” 或 “OR”，where 元素也会将它们去除。
```xml
<select id="queryBlogIf" resultType="blog" parameterType="map">
        select * from blog
        <where>
            <if test="tit != null">
                and title = #{tit}
            </if>
            <if test="author != null">
                and author = #{author}
            </if>
        </where>
    </select>
```
- set | set 元素可以用于动态包含需要更新的列，忽略其它不更新的列。set 元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号
```xml
<update id="updateBlog" parameterType="map">
        update blog
        <set>
            <if test="tit != null">
                title = #{tit},
            </if>
            <if test="author != null">
                author = #{author},
            </if>
        </set>
        <where>
            id = #{id}
        </where>
    </update>
```
- trim  

| 属性      | 描述 |
| :---:       |    :----:   |
| prefix      | 给sql语句拼接的前缀       |
| suffix   | 给sql语句拼接的后缀       |
| prefixOverrides   | 去除sql语句前面的关键字或者字符，该关键字或者字符由prefixOverrides属性指定，假设该属性指定为"AND"，当sql语句的开头为"AND"，trim标签将会去除该"AND"       |
| suffixOverrides   | 去除sql语句后面的关键字或者字符，该关键字或者字符由suffixOverrides属性指定       |

使用trim实现where标签作用
```xml
<trim prefix="WHERE" prefixOverrides="AND |OR ">
  ...
</trim>
```
使用trim实现set标签作用
```xml
<trim prefix="SET" suffixOverrides=",">
  ...
</trim>
```

## SQL片段 <sql>
- 使用sql标签抽取公共的部分  
```xml
<sql id="my_if">
	<if test="tit != null">
		and title = #{tit}
	</if>
	<if test="author != null">
		and author = #{author}
	</if>
</sql>
```
- 在需要使用的地方使用include标签引用即可
```xml
<where>
	<include refid="my_if"></include>
</where>
```
注意事项：
- 最好基于单表来定义sql片段
- sql片段中最好不要有where标签

## foreach
动态 SQL 的另一个常见使用场景是对集合进行遍历（尤其是在构建 IN 条件语句的时候  
- 接口
```java
List<Blog> queryBlogForeach(Map map);
```
- mapper.xml
```xml
<select id="queryBlogForeach" resultType="blog" parameterType="map">
		select * from blog
		<!-- 第一种遍历方式：Preparing: select * from blog WHERE ( id = ? or id = ? or id = ? ) -->
		<where>
				<foreach collection="ids" item="bid" open="and (" close=")" separator="or ">
						id = #{bid}
				</foreach>
		</where>
		<!-- 第二种遍历方式：Preparing: select * from blog WHERE id in ( ? , ? , ? )  -->
<!--        <where>-->
<!--            <foreach collection="ids" item="bid" open="id in (" close=")" separator=",">-->
<!--                #{bid}-->
<!--            </foreach>-->
<!--        </where>-->
</select>
```
- 测试类
```java
@Test
    public void test5(){
        Map map = new HashMap();
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        map.put("ids",list);
        List<Blog> blogs = blogMapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
```
