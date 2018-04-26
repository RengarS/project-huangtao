package com.huangtao.order.controller;

import com.huangtao.order.service.FoodsService;
import domains.order.OrderMenu;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods/")
public class FoodsController {

    @Autowired
    FoodsService foodsService;

    @GetMapping("showfoods/{name}")
    public OrderMenu getFoods(@PathVariable("name") @NotBlank String name) {
        return foodsService.getTypeFoods(name);
    }
}
