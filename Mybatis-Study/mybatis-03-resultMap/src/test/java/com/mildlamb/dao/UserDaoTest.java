package com.mildlamb.dao;

import com.mildlamb.pojo.User;
import com.mildlamb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    //获取sqlSession对象
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserDao mapper = sqlSession.getMapper(UserDao.class);



    @Test
    public void test2(){
        List<User> kindred = mapper.getUserByName("kindred");
        for (User user : kindred) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
