package com.huangtao.web.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/user/")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User getUserInfo(@PathVariable("id") String id) {

        return restTemplate.getForObject("http://user/user/" + id, User.class);
    }

    @GetMapping(value = "/index")
    @ResponseBody
    public String TestController() {

        return "我是  web2";
    }
}

    @Data
    class User {
        private int id;
        private String name;
}
