package com.adareas.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.adareas.entity.AmapArea;
import com.adareas.entity.LbsArea;

import java.util.ArrayList;
import java.util.List;

import static com.adareas.utils.PinYinUtil.captureName;

public class AreasUtils {
    public static List<AmapArea> getAmapAreas(JSONArray a) {
        List<AmapArea> arrayList = new ArrayList<>();
        int i = a.size();
        while (i > 0) {
            JSONObject b = JSON.parseObject(a.getString(a.size() - i));
            AmapArea amapArea = new AmapArea(b.getString("citycode"), b.getString("adcode"), b.getString("level"), b.getString("center"), b.getString("name"), getAmapAreas(b.getJSONArray("districts")));
            arrayList.add(amapArea);
            i--;
        }
        return arrayList;
    }

    public static List<LbsArea> getLbsAreas(JSONArray a) {
        List<LbsArea> arrayList = new ArrayList<>();
        int i = a.size();
        while (i > 0) {
            List<LbsArea> p = getLbsArea(JSON.parseArray(a.getString(a.size() - i)));
            arrayList.addAll(p);
            i--;
        }
        return arrayList;
    }

    private static List<LbsArea> getLbsArea(JSONArray array) {
        List<LbsArea> arrayList = new ArrayList<>();
        int i = array.size();
        while (i > 0) {
            JSONObject b = JSON.parseObject(array.getString(array.size() - i));
            JSONArray pinyinArray = b.getJSONArray("pinyin");
            StringBuilder pinyin = new StringBuilder();
            if (pinyinArray != null) for (int j = 0; j < pinyinArray.size(); j++) {
                String pinyinChar = pinyinArray.getString(j);
                if (j == 0) pinyinChar = captureName(pinyinChar);
                pinyin.append(pinyinChar);
            }
            LbsArea lbsArea = new LbsArea(b.getString("id"), b.getString("name"), b.getString("fullname"), pinyin.toString());
            arrayList.add(lbsArea);

            i--;
        }
        return arrayList;
    }


}
