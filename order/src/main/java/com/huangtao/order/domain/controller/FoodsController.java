package com.huangtao.order.domain.controller;

import com.huangtao.order.domain.service.FoodsService;
import domains.order.dto.FoodsDO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/foods/")
public class FoodsController {

    @Autowired
    FoodsService foodsService;

    @GetMapping("showfoods/{name}")
    public List<FoodsDO>  getFoods(@RequestParam @NotBlank String name){
        return foodsService.getFoods(name);
    }
}
