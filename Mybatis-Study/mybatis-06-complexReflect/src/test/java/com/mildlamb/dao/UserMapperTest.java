package com.mildlamb.dao;

import com.mildlamb.pojo.Champion;
import com.mildlamb.pojo.Master;
import com.mildlamb.pojo.Master2;
import com.mildlamb.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private MasterMapper masterMapper = sqlSession.getMapper(MasterMapper.class);
    private ChampionMapper championMapper = sqlSession.getMapper(ChampionMapper.class);


    @Test
    public void test1(){
        List<Champion> champions = championMapper.getChampions();
        for (Champion champion : champions) {
            System.out.println(champion);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        List<Champion> champions = championMapper.getChampions2();
        for (Champion champion : champions) {
            System.out.println(champion);
        }
        sqlSession.close();
    }

    //---------------------------------
    @Test
    public void test_2(){
        Master2 master2 = masterMapper.getMaster(2);
        System.out.println(master2);
        sqlSession.close();
    }

    @Test
    public void test_2_2(){
        Master2 master2 = masterMapper.getMaster2(1);
        System.out.println(master2);
        sqlSession.close();
    }

}
