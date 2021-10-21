package com.mildlamb.dao;

import com.mildlamb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User getUserById(@Param("uid") Integer id);

    int updateUser(User user);
}
