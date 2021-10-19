package com.mildlamb.dao;

import com.mildlamb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //通过用户名查询用户
    List<User> getUserByName(String name);

}
