package com.mildlamb.dao;

import com.mildlamb.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{uid}")
    User getUserById(@Param("uid") Integer id,@Param("name") String name);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update user set name = #{name},pwd = #{pwd} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int delUser(@Param("uid") Integer id);
}