package com.mildlamb.pojo;

import lombok.Data;

@Data
public class Champion {
    private Integer id;
    private String name;

    //学生需要关联一个老师
    private Master master;
}
