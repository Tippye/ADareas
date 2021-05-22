package com.adareas.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class Request {
    private String AmapKey = "填写你的高德地图开发者key";
    private String TencentKey = "填写你的腾讯地图开发者key";
    // https://www.nowapi.com/api/life.postcode
    private String ZipcodeKey = "NOWapi的appkey";
    private String ZipcodeSign = "NOWapi的sign";
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 生成post请求的JSON请求参数
     *
     * @return
     */
    public HttpEntity<Map<String, String>> generatePostJson(Map<String, String> jsonMap) {

        //如果需要其它的请求头信息、都可以在这里追加
        HttpHeaders httpHeaders = new HttpHeaders();

        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

        httpHeaders.setContentType(type);

        return new HttpEntity<>(jsonMap, httpHeaders);
    }


    /**
     * 生成get参数请求url
     * 示例：https://0.0.0.0:80/api?u=u&o=o
     * 示例：https://0.0.0.0:80/api
     *
     * @param protocol 请求协议 示例: http 或者 https
     * @param uri      请求的uri 示例: 0.0.0.0:80
     * @param params   请求参数
     * @return
     */
    public String generateRequestParameters(String protocol, String uri, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(protocol).append("://").append(uri);
        sb.append("?");
        for (Map.Entry map : params.entrySet()) {
            sb.append(map.getKey())
                    .append("=")
                    .append(map.getValue())
                    .append("&");
        }
        uri = sb.substring(0, sb.length() - 1);
        return uri;
    }

    /**
     * 请求高德地图Api
     *
     * @return
     */
    public String districtAmap() {
        Map<String, String> uriMap = new HashMap<>(6);
        uriMap.put("key", AmapKey);
        uriMap.put("subdistrict", "4");
        ResponseEntity responseEntity = restTemplate.getForEntity(
                generateRequestParameters("https", "restapi.amap.com/v3/config/district", uriMap),
                String.class
        );
        return (String) responseEntity.getBody();
    }

    /**
     * 请求腾讯地图Api
     *
     * @return
     */
    public String districtLbs() {
        Map<String, String> uriMap = new HashMap<>(6);
        uriMap.put("key", TencentKey);
        ResponseEntity responseEntity = restTemplate.getForEntity(
                generateRequestParameters("https", "apis.map.qq.com/ws/district/v1/list", uriMap),
                String.class
        );
        return (String) responseEntity.getBody();
    }

    /**
     * 请求第三方Api获取邮政编码
     * @param areaName 地区名称
     * @return
     */
    public String postZip(String areaName) {
        Map<String, String> uriMap = new HashMap<>(6);
        uriMap.put("areaname", areaName);
        uriMap.put("appKey", ZipcodeKey);
        uriMap.put("sign", ZipcodeSign);
        ResponseEntity responseEntity = restTemplate.getForEntity(
                generateRequestParameters("http", "http://api.k780.com", uriMap),
                String.class
        );
        return (String) responseEntity.getBody();
    }
}
