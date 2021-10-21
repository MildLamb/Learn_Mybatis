package com.mildlamb.dao;

import com.mildlamb.pojo.Master;
import com.mildlamb.pojo.Master2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MasterMapper {
    public Master2 getMaster(@Param("mid") Integer id);

    public Master2 getMaster2(@Param("mid") Integer id);
}
