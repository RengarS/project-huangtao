package com.huangtao.web.controller;

import com.alibaba.fastjson.JSON;
import domains.order.dto.FoodsDO;
import domains.order.dto.ShopsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    //获取商家列表
    @RequestMapping(value = "/shops", method = RequestMethod.GET)
    public List<ShopsDO> get() {
        return restTemplate.getForObject("http://order/shops/showshops", List.class);
    }


    //获取一个商家的在售商品
    @RequestMapping("/foods/{name}")
    public List<FoodsDO> getFoods(@PathVariable String name) {
        return restTemplate.getForObject("http://order/foods/showfoods/" + name, List.class);

    }
}
