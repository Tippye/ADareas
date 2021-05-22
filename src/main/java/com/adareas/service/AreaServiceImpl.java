package com.adareas.service;

import com.adareas.entity.Area;
import com.adareas.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaMapper areaMapper;

    @Override
    public Area[] Sel(String ID) {
        return areaMapper.Sel(ID);
    }

    @Override
    public Area[] SelChild(String ID) {
        return areaMapper.SelChild(ID);
    }

    @Override
    public Area[] SelProvince(int page, int pageSize) {
        return areaMapper.SelCitys("2", (page - 1) * pageSize, page * pageSize);
    }

    @Override
    public Area[] SelCity(int page, int pageSize) {
        return areaMapper.SelCitys("3", (page - 1) * pageSize, page * pageSize);
    }

    @Override
    public Area[] SelCity(int page, int pageSize, String path) {
        return areaMapper.SelCitysbyPath("3", (page - 1) * pageSize, page * pageSize, path);
    }


    @Override
    public Area[] SelDistrict(int page, int pageSize) {
        return areaMapper.SelCitys("4", (page - 1) * pageSize, page * pageSize);
    }

    @Override
    public Area[] SelDistrict(int page, int pageSize, String path) {
        return areaMapper.SelCitysbyPath("4", (page - 1) * pageSize, page * pageSize, path);
    }

    @Override
    public Area[] SelVillage(int page, int pageSize) {
        return areaMapper.SelCitys("5", (page - 1) * pageSize, page * pageSize);
    }

    @Override
    public Area[] SelVillage(int page, int pageSize, String path) {
        return areaMapper.SelCitysbyPath("5", (page - 1) * pageSize, page * pageSize, path);
    }

    @Override
    public Integer Add(Area area) {
        return areaMapper.Add(area);
    }

    @Override
    public Integer Del(String id) {
        return areaMapper.Del(id);
    }

    @Override
    public Integer Update(Area area) {
        return areaMapper.Update(area);
    }
}
