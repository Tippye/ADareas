package com.adareas.mapper;

import com.adareas.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AreaMapper {
    Area[] Sel(@Param("ID") String ID);

    Area[] SelChild(@Param("ID") String ID);

    Area[] SelCitys(String level, int start, int end);

    Area[] SelCitysbyPath(String level, int start, int end, String path);

    Integer Add(Area area);

    Integer Del(String ID);

    Integer Update(Area area);
}