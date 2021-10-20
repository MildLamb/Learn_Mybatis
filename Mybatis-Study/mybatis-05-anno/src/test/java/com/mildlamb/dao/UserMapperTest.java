package com.mildlamb.dao;

import com.mildlamb.pojo.User;
import com.mildlamb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    //获取sqlSession对象
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void test(){
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        User user = mapper.getUserById(2,"test");
            System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test3(){
        mapper.addUser(new User(6,"test","123456"));

        sqlSession.close();
    }

    @Test
    public void test4(){
        User test = mapper.getUserById(6, "test");
        test.setName("TEST");
        test.setPwd("654321");
        mapper.updateUser(test);
        sqlSession.close();
    }

    @Test
    public void test5(){
        mapper.delUser(6);
        sqlSession.close();
    }
}
