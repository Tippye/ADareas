package com.adareas.service;

import com.adareas.entity.Area;
import org.apache.ibatis.annotations.Param;

public interface AreaService {
    Area[] Sel(@Param("ID") String ID);

    Area[] SelChild(@Param("ID") String ID);

    Area[] SelProvince(int page, int pageSize);

    Area[] SelCity(int page, int pageSize);

    Area[] SelCity(int page, int pageSize, String path);

    Area[] SelDistrict(int page, int pageSize);

    Area[] SelDistrict(int page, int pageSize, String path);

    Area[] SelVillage(int page, int pageSize);

    Area[] SelVillage(int page, int pageSize, String path);

    Integer Add(Area area);

    Integer Del(String ID);

    Integer Update(Area area);
}
