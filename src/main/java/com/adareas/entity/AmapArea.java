package com.adareas.entity;

import java.util.List;

/**
 * 高德数据类
 */
public class AmapArea {
    private String citycode;
    private String adcode;
    private String level;
    private String center;
    private String name;
    private List<AmapArea> districts;

    @Override
    public String toString() {
        return "AmapArea{" +
                "citycode='" + citycode + '\'' +
                ", adcode='" + adcode + '\'' +
                ", level='" + level + '\'' +
                ", center='" + center + '\'' +
                ", name='" + name + '\'';
    }

    public AmapArea(String citycode, String adcode, String level, String center, String name, List<AmapArea> districts) {
        this.citycode = citycode;
        this.adcode = adcode;
        this.level = level;
        this.center = center;
        this.name = name;
        this.districts = districts;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AmapArea> getDistricts() {
        return districts;
    }

    public void setDistricts(List<AmapArea> districts) {
        this.districts = districts;
    }
}
