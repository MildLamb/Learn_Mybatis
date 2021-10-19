package com.mildlamb.dao;

import com.github.pagehelper.PageHelper;
import com.mildlamb.pojo.User;
import com.mildlamb.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    //获取sqlSession对象
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserDao mapper = sqlSession.getMapper(UserDao.class);

    static Logger logger =  Logger.getLogger(UserDaoTest.class);



    @Test
    public void test2(){
        List<User> kindred = mapper.getUserByName("kindred");
        for (User user : kindred) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j方法");
        logger.debug("debug:进入了testLog4j方法");
        logger.error("error:进入了testLog4j方法");
    }

    @Test
    public void testLimit(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("start",0);
        map.put("size",3);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void testRowBounds(){

        //使用RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 3);

        List<User> users = sqlSession.selectList("com.mildlamb.dao.UserDao.getUserByRowBounds",null,rowBounds);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testPageHelper(){
        PageHelper.startPage(3,2);
        List<User> userByLimit = mapper.getUserByHelper();
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testPageHelper2(){
        PageHelper.offsetPage(3,2);
        List<User> userByLimit = mapper.getUserByHelper();
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
