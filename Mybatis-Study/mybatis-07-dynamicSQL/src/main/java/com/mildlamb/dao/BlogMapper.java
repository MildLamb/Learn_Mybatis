package com.mildlamb.dao;

import com.mildlamb.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIf(Map<String,String> map);
    //选择查询
    List<Blog> queryBlogChoose(Map<String,String> map);
    //更新博客
    int updateBlog(Map<String,String> map);
    //遍历博客
    List<Blog> queryBlogForeach(Map map);
}
