package com.huangtao.order.controller;

import com.huangtao.order.service.FoodsService;
import domains.order.dto.FoodsDO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods/")
public class FoodsController {

    @Autowired
    FoodsService foodsService;

    @GetMapping("showfoods/{name}")
    public List<FoodsDO> getFoods(@PathVariable("name") @NotBlank String name) {
        return foodsService.getFoods(name);
    }
}
