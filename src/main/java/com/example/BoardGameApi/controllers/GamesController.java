package com.example.BoardGameApi.controllers;

import org.json.XML;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@RestController
public class GamesController {


    public String externalGetRequest(String url){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject xmlJSONobj = XML.toJSONObject(result);
        return xmlJSONobj.toString(2);
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> defaultRoute(
            @RequestParam(name="search") String searchString
    ){
        String url = "https://api.geekdo.com/xmlapi2/search?query=" + searchString;

        return new ResponseEntity<>(externalGetRequest(url), HttpStatus.OK);
    }

    @GetMapping(value="/user")
    public ResponseEntity<String> getUserDetails(
            @RequestParam (name= "name") String username){
        String url = "https://api.geekdo.com/xmlapi2/collection?username=" + username;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        while(result == ""){

        }
        JSONObject xmlJSONobj = XML.toJSONObject(result);
        String jsonPrettyPrintString = xmlJSONobj.toString(2);
        return new ResponseEntity<>(jsonPrettyPrintString, HttpStatus.OK);
    }

    @GetMapping(value="/game")
    public ResponseEntity<String> getGameDetails(
            @RequestParam (name= "id") String id){
        String url = "https://api.geekdo.com/xmlapi2/thing?id=" + id;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        JSONObject xmlJSONobj = XML.toJSONObject(result);
        String jsonPrettyPrintString = xmlJSONobj.toString(2);
        return new ResponseEntity<>(jsonPrettyPrintString, HttpStatus.OK);
    }
}
