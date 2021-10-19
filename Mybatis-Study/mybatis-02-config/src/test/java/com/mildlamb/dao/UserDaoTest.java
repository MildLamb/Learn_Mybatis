package com.mildlamb.dao;

import com.mildlamb.pojo.User;
import com.mildlamb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    //获取sqlSession对象
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserDao mapper = sqlSession.getMapper(UserDao.class);

    @Test
    public void test(){
        //执行sql,方式1：getMapper

        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭资源
        sqlSession.close();
    }
}
