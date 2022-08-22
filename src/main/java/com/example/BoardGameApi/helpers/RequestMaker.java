package com.example.BoardGameApi.helpers;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.client.RestTemplate;

public class RequestMaker {

    public static String externalGetRequest(String url){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject xmlToJsonObject = XML.toJSONObject(result);
        return xmlToJsonObject.toString(2);
    }
}
