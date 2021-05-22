package com.adareas.entity;

/**
 * 腾讯数据类
 */
public class LbsArea {
    private String id;
    private String name;
    private String fullname;
    private String pinyin;

    public LbsArea(String id, String name, String fullname, String pinyin) {
        this.id = id;
        this.name = name;
        this.fullname = fullname;
        this.pinyin = pinyin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
