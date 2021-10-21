package com.mildlamb.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;  //属性名和字段名不一致，但符合驼峰命名
    private Integer views;
}
