package com.adareas.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.adareas.api.Request;
import com.adareas.entity.AmapArea;
import com.adareas.entity.Area;
import com.adareas.entity.LbsArea;
import com.adareas.service.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.adareas.utils.AreasUtils.getLbsAreas;

@RestController
@RequestMapping("/area")
public class AreaController {
    Request request;

    @Autowired
    private AreaServiceImpl areaService;

    @GetMapping("/{ID}")
    public Object GetArea(@PathVariable String ID) {
        Area[] areas = areaService.Sel(ID);
        if (areas == null) return "没有该城市";
        return areas;
    }

    @PostMapping("/")
    public int AddArea(@RequestBody Area area) {
        return areaService.Add(area);
    }

    @RequestMapping("/update")
    public String UpdateDate() {
        request = new Request();
        String s = "";
        s += getCitys();
        s += "\n";
        s += getShortNamePinyin();
        s += "\n";
        s += getZipCode();
        s += "\n";
        s += supplementary();
        return s;
    }

    /**
     * 调用高德地图Api添加省市区县的ID,ParentId,FullName,LevelType,ParentPath,CityCode,lng,Lat等信息
     */
    public String getCitys() {
        return "高德数据添加成功";
//        JSONArray districts = JSON.parseObject(request.districtAmap()).getJSONArray("districts");
//        List<AmapArea> amapAreaList = getAmapAreas(districts);
//        amapAddToDatabase(amapAreaList, null, null, null, null);
//        System.out.println("高德数据添加成功");
//        return "高德数据添加成功";
    }

    /**
     * 调用腾讯地图Api添加CityShortName,ProvincePinyin,CityPinyin等信息
     */
    public String getShortNamePinyin() {
        Request request = new Request();
        JSONArray lbsDistricts = JSON.parseObject(request.districtLbs()).getJSONArray("result");
        List<LbsArea> lbsAreaList = getLbsAreas(lbsDistricts);
        lbsAddToDatabase(lbsAreaList);
        System.out.println("腾讯数据添加成功");
        return "腾讯数据添加成功";
    }

    /**
     * 补充数据库内容
     * （循环方法，待优化）
     */
    @RequestMapping("/supplementary")
    public String supplementary() {
        // TODO optimization algorithm
        try {
            Area[] areas2 = areaService.SelProvince(1, 999999);
            for (Area a2 : areas2) {
                Area[] areas3 = areaService.SelCity(1, 999999, a2.getID());
                for (Area a3 : areas3) {
                    areaService.Update(setData(a3, a2));
                    Area[] areas4 = areaService.SelDistrict(1, 999999, a2.getID() + ',' + a3.getID());
                    for (Area a4 : areas4) {
                        areaService.Update(setData(a4, a2, a3));
                        Area[] areas5 = areaService.SelVillage(1, 999999, a2.getID() + ',' + a3.getID());
                        for (Area a5 : areas5) {
                            areaService.Update(setData(a5, a2, a3, a4));
                        }
                    }
                }
            }
            System.out.println("补充完成");
            return "补充完成";
        } catch (OutOfMemoryError e) {
            System.out.println(e);
            return "内存溢出，补充失败";
        } catch (Error e) {
            System.out.println(e);
            return "补充失败";
        }
    }

    @RequestMapping("/polishPinyin/{str}")
    public static String polishPinyin(@PathVariable String str) {
        // TODO polish hanyupinyin to get JianPin
        return "该功能暂未实现，敬请期待！";
    }

    /**
     * 调用第三方Api添加ZipCode
     */
    @RequestMapping("/updateZip")
    public static String getZipCode() {
        // TODO get zipcode from third party
        return "暂未实现，敬请期待";
//        int page = 1;
//        int pageSize = 2;
//        Area[] areas = areaService.SelCity(page, pageSize);
//        for (Area area : areas) {
//            String s = request.postZip(area.getFullName());
//            JSONObject o = JSON.parseObject(s);
//            JSONArray lists = o.getJSONObject("result").getJSONArray("lists");
//            for (int i = 0; i < lists.size(); i++) {
//                JSONObject item = JSON.parseObject(lists.getString(i));
//                if (item.getString("areaid").equals(area.getCityCode())) area.setZipCode(item.getString("postcode"));
//            }
//            areaService.Update(area);
//        }
//        return "更新完成";
    }

    private int DelArea(String ID) {
        return areaService.Del(ID);
    }

    /**
     * 将高德的数据添加到数据库中
     *
     * @param list       高德数据的列表
     * @param parentPath 路径（id组成）
     * @param province   省份名称
     * @param city       市名称
     * @param district   县/区 名称
     */
    private void amapAddToDatabase(List<AmapArea> list, String parentPath, String province, String city, String district) {
        String parentAdcode = parentPath == null ? "" : parentPath.split(",")[parentPath.split(",").length - 1];
        for (AmapArea item : list) {
            String pro = item.getLevel().equals("province") ? item.getName() : province;
            String cit = item.getLevel().equals("city") ? item.getName() : city;
            String dis = item.getLevel().equals("district") ? item.getName() : district;
            String pPath = (parentPath == null ? "" : parentPath + ",") + item.getAdcode();
            String level = "" + pPath.split(",").length;
            String citycode = item.getCitycode();
            if (citycode.equals("[]")) citycode = null;
            Area a = new Area(item.getAdcode(), parentAdcode, level, item.getName(), null, pPath, pro, cit, dis, null, null, null, null, null, null, citycode, null, null, null, null, item.getCenter().split(",")[0], item.getCenter().split(",")[1], null, null);
            areaService.Add(a);
            if (item.getDistricts().size() > 0) amapAddToDatabase(item.getDistricts(), pPath, pro, cit, dis);
        }
    }

    /**
     * 将腾讯的数据添加到数据库中
     *
     * @param list 腾讯数据组成的数组
     */
    private void lbsAddToDatabase(List<LbsArea> list) {
        for (LbsArea lbsArea : list) {
            Area[] areas = areaService.Sel(lbsArea.getId());
            if (areas == null) continue;
            for (Area area : areas) {
                area.setFullName(lbsArea.getFullname());
                area.setShortName(lbsArea.getName());
                if (lbsArea.getPinyin() != null && !lbsArea.getPinyin().equals("")) {
                    area.setPinyin(lbsArea.getPinyin());
                    area.setFirstChar(lbsArea.getPinyin().charAt(0) + "");
                }
                Area[] childAreas = areaService.SelChild(area.getID());
                switch (Objects.requireNonNull(area).getLevelType()) {
                    case "2":
                        lbsAreaToArea(area, lbsArea);
                        for (Area childArea : childAreas) {
                            areaService.Update(lbsAreaToArea(childArea, lbsArea));
                        }
                        break;
                    case "3":
                        lbsAreaToArea(area, null, lbsArea);
                        for (Area childArea : childAreas) {
                            areaService.Update(lbsAreaToArea(setData(childArea, area), null, lbsArea));
                        }
                        break;
                    case "4":
                        lbsAreaToArea(area, null, null, lbsArea);
                        for (Area childArea : childAreas) {
                            areaService.Update(lbsAreaToArea(setData(childArea, area, area), null, null, lbsArea));
                        }
                        break;
                }
                areaService.Update(area);
            }
        }
    }

    private static Area setData(Area changed, Area pro, Area cit, Area dis) {
        Area a = setData(changed, pro, cit);
        a.setDistrict(dis.getDistrict());
        a.setDistrictPinyin(dis.getDistrictPinyin());
        a.setDistrictShortName(dis.getDistrictShortName());
        return a;
    }

    private static Area setData(Area changed, Area pro, Area cit) {
        Area a = setData(changed, pro);
        a.setCity(cit.getCity());
        a.setCityPinyin(cit.getPinyin());
        a.setCityShortName(cit.getCityShortName());
        return a;
    }

    private static Area setData(Area changed, Area pro) {
        changed.setProvince(pro.getProvince());
        changed.setProvincePinyin(pro.getProvincePinyin());
        changed.setProvinceShortName(pro.getProvinceShortName());
        return changed;
    }

    private static Area lbsAreaToArea(Area area, LbsArea pro, LbsArea cit, LbsArea dis) {
        area = lbsAreaToArea(area, pro, cit);
        if (dis != null) {
            area.setDistrict(dis.getFullname());
            area.setDistrictPinyin(dis.getPinyin());
            area.setDistrictShortName(dis.getName());
        }
        return area;
    }

    private static Area lbsAreaToArea(Area area, LbsArea pro, LbsArea cit) {
        area = lbsAreaToArea(area, pro);
        if (cit != null) {
            area.setCity(cit.getFullname());
            area.setCityPinyin(cit.getPinyin());
            area.setCityShortName(cit.getName());
        }
        return area;
    }

    private static Area lbsAreaToArea(Area area, LbsArea pro) {
        if (pro != null) {
            area.setProvince(pro.getFullname());
            area.setProvincePinyin(pro.getPinyin());
            area.setProvinceShortName(pro.getName());
        }
        return area;
    }
}
