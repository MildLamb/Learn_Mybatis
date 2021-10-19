package com.mildlamb.dao;

import com.mildlamb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //通过用户名查询用户
    List<User> getUserByName(String name);
    //使用limit分页
    List<User> getUserByLimit(Map<String,Integer> map);
    //使用RowBounds进行分页
    List<User> getUserByRowBounds();
    //使用pageHelper进行分页
    List<User> getUserByHelper();

}
