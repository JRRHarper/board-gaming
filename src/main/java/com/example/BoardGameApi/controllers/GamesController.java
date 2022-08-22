package com.example.BoardGameApi.controllers;

import com.example.BoardGameApi.helpers.RequestMaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {

    @GetMapping(value = "/")
    public ResponseEntity<String> defaultRoute(
            @RequestParam(name="search") String searchString
    ){
        String url = "https://api.geekdo.com/xmlapi2/search?query=" + searchString;
        String response = RequestMaker.externalGetRequest(url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value="/user")
    public ResponseEntity<String> getUserDetails(
            @RequestParam (name= "name") String username){
        String url = "https://api.geekdo.com/xmlapi2/collection?username=" + username;
        String response = RequestMaker.externalGetRequest(url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value="/game")
    public ResponseEntity<String> getGameDetails(
            @RequestParam (name= "id") String id){
        String url = "https://api.geekdo.com/xmlapi2/thing?id=" + id;
        String response = RequestMaker.externalGetRequest(url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
