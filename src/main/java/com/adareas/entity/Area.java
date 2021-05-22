package com.adareas.entity;

/**
 * 地区类
 */
public class Area {
    private String ID;
    private String ParentId;
    private String LevelType;
    private String FullName;
    private String ShortName;
    private String ParentPath;
    private String Province;
    private String City;
    private String District;
    private String ProvinceShortName;
    private String CityShortName;
    private String DistrictShortName;
    private String ProvincePinyin;
    private String CityPinyin;
    private String DistrictPinyin;
    private String CityCode;
    private String ZipCode;
    private String Pinyin;
    private String Jianpin;
    private String FirstChar;
    private String lng;
    private String Lat;
    private String Remark1;
    private String Remark2;

    public Area(String ID, String parentId, String levelType, String fullName, String shortName, String parentPath, String province, String city, String district, String provinceShortName, String cityShortName, String districtShortName, String provincePinyin, String cityPinyin, String districtPinyin, String cityCode, String zipCode, String pinyin, String jianpin, String firstChar, String lng, String lat, String remark1, String remark2) {
        this.ID = ID;
        this.ParentId = parentId;
        this.LevelType = levelType;
        this.FullName = fullName;
        this.ShortName = shortName;
        this.ParentPath = parentPath;
        this.Province = province;
        this.City = city;
        this.District = district;
        this.ProvinceShortName = provinceShortName;
        this.CityShortName = cityShortName;
        this.DistrictShortName = districtShortName;
        this.ProvincePinyin = provincePinyin;
        this.CityPinyin = cityPinyin;
        this.DistrictPinyin = districtPinyin;
        this.CityCode = cityCode;
        this.ZipCode = zipCode;
        this.Pinyin = pinyin;
        this.Jianpin = jianpin;
        this.FirstChar = firstChar;
        this.lng = lng;
        this.Lat = lat;
        this.Remark1 = remark1;
        this.Remark2 = remark2;
    }

    @Override
    public String toString() {
        return "Area{" +
                "ID='" + ID + '\'' +
                ", ParentId='" + ParentId + '\'' +
                ", LevelType='" + LevelType + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Province='" + Province + '\'' +
                ", City='" + City + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }

    public String getLevelType() {
        return LevelType;
    }

    public void setLevelType(String levelType) {
        LevelType = levelType;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getParentPath() {
        return ParentPath;
    }

    public void setParentPath(String parentPath) {
        ParentPath = parentPath;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getProvinceShortName() {
        return ProvinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        ProvinceShortName = provinceShortName;
    }

    public String getCityShortName() {
        return CityShortName;
    }

    public void setCityShortName(String cityShortName) {
        CityShortName = cityShortName;
    }

    public String getDistrictShortName() {
        return DistrictShortName;
    }

    public void setDistrictShortName(String districtShortName) {
        DistrictShortName = districtShortName;
    }

    public String getProvincePinyin() {
        return ProvincePinyin;
    }

    public void setProvincePinyin(String provincePinyin) {
        ProvincePinyin = provincePinyin;
    }

    public String getCityPinyin() {
        return CityPinyin;
    }

    public void setCityPinyin(String cityPinyin) {
        CityPinyin = cityPinyin;
    }

    public String getDistrictPinyin() {
        return DistrictPinyin;
    }

    public void setDistrictPinyin(String districtPinyin) {
        DistrictPinyin = districtPinyin;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getPinyin() {
        return Pinyin;
    }

    public void setPinyin(String pinyin) {
        Pinyin = pinyin;
    }

    public String getJianpin() {
        return Jianpin;
    }

    public void setJianpin(String jianpin) {
        Jianpin = jianpin;
    }

    public String getFirstChar() {
        return FirstChar;
    }

    public void setFirstChar(String firstChar) {
        FirstChar = firstChar;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getRemark1() {
        return Remark1;
    }

    public void setRemark1(String remark1) {
        Remark1 = remark1;
    }

    public String getRemark2() {
        return Remark2;
    }

    public void setRemark2(String remark2) {
        Remark2 = remark2;
    }
}
