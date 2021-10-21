package com.mildlamb.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Master2 {
    private Integer id;
    private String name;

    private List<Champion2> champions;
}
