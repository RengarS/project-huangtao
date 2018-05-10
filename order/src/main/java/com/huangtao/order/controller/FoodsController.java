package com.huangtao.order.controller;

import com.huangtao.order.service.FoodsService;
import domains.order.OldFood;
import domains.order.OrderMenu;
import domains.order.dto.Foods;
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
    public OrderMenu getFoods(@PathVariable("name") @NotBlank String name) {
        return foodsService.getTypeFoods(name);
    }

    @GetMapping("getfoods/{id}")
    public List<Foods> getAllFoods(@PathVariable("id") @NotBlank String id){
        return foodsService.getAllFoods(id);
    }

    /**
     * 更新商品信息（PC端用）
     * @param foodId
     * @param foodPrice
     * @return
     */
    @GetMapping("updatefoods")
    public boolean updatefoods(@RequestParam("foodId") String foodId, @RequestParam("foodPrice") String foodPrice){
        return foodsService.updatefood(foodId,foodPrice);
    }

    /**
     * 根据商品ID获取商品信息（PC端用于渲染更新页面）
     * @param id
     * @return OldFood
     */
    @GetMapping("getoldfood/{id}")
    public OldFood getOldFoodById(@PathVariable("id") @NotBlank String id){
        return foodsService.getOldFoodById(id);
    }

}
