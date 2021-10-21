package com.mildlamb.dao;

import com.mildlamb.pojo.Blog;
import com.mildlamb.utils.IdUtils;
import com.mildlamb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

    @Test
    public void test(){
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("心花怒放");
        blog.setAuthor("妮蔻");
        blog.setCreateTime(new Date());
        blog.setViews(666);
        blogMapper.addBlog(blog);
        sqlSession.close();
    }

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

    @Test
    public void test4(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("tit","被冰冻的千年");
//        map.put("author","纳尔");
        map.put("id","f3a1525a7e904c4a97bda53205417cbd");
        blogMapper.updateBlog(map);
        sqlSession.close();
    }

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
}
