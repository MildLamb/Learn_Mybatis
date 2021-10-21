package com.mildlamb;

import com.mildlamb.dao.UserMapper;
import com.mildlamb.pojo.User;
import com.mildlamb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private SqlSession sqlSession2 = MybatisUtils.getSqlSession();
    private UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    private UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

    @Test
    public void test(){
        User user = userMapper.getUserById(1);
        System.out.println(user);

//        userMapper.updateUser(new User(2,"Gnar","W2snowgnar"));
//        sqlSession.clearCache(); //手动清理缓存

        System.out.println("=============================");
        User user2 = userMapper.getUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);
        sqlSession.close();
    }

    @Test
    public void test2(){
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

        User user2 = userMapper2.getUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);
        sqlSession2.close();

    }
}
