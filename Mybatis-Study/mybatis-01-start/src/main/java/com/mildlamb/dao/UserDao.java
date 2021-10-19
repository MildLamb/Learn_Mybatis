package com.mildlamb.dao;

import com.mildlamb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询全部用户
    List<User> getUserList();
    //通过用户名查询用户
    List<User> getUserByName(String name);
    //添加一个用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int delUser(Integer id);

    //万能的Map集合
    int updateUser2(Map<String,Object> map);

    //模糊查询
    List<User> getUserLike(String name);

}
