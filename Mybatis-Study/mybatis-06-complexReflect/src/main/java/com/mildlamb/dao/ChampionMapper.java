package com.mildlamb.dao;

import com.mildlamb.pojo.Champion;

import java.util.List;

public interface ChampionMapper {
    //查询所有的英雄信息和所属召唤师信息
    public List<Champion> getChampions();

    //查询所有的英雄信息和所属召唤师信息
    public List<Champion> getChampions2();
}
