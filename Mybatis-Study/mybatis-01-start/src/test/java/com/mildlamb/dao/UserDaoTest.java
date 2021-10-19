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
    public void test(){

        //执行sql,方式1：getMapper

        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //方式二
//        List<User> users = sqlSession.selectList("com.mildlamb.dao.UserDao.getUserList");
//        for (User user : users) {
//            System.out.println(user);
//        }

        //关闭资源
        sqlSession.close();
    }

    @Test
    public void test2(){
        List<User> kindred = mapper.getUserByName("kindred");
        for (User user : kindred) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test3(){
        User user = new User(4,"qsj","123456");
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        List<User> kindred = mapper.getUserByName("kindred");
        kindred.get(0).setName("Kindred");
        mapper.updateUser(kindred.get(0));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5(){
        mapper.delUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","QSJ");
        map.put("uid",4);
        mapper.updateUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test7(){
        List<User> kind = mapper.getUserLike("%kind%");
        for (User user : kind) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
