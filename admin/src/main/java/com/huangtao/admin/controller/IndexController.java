package com.huangtao.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class IndexController {

    @GetMapping("/index1")
    public String index() {
        System.out.println("==============");
        return "index";
    }
}
