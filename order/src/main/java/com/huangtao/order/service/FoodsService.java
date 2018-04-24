package com.huangtao.order.service;

import com.huangtao.order.repo.FoodsDAO;
import domains.order.dto.FoodsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodsService {

    @Autowired
    FoodsDAO foodsDAO;

    //获取一个商家所有在售的商品
    public List<FoodsDO> getFoods(String name) {
        return foodsDAO.getFoods(name);
    }

    public Map<String, List<FoodsDO>> getTypeFoods(String store) {
        Map<String, List<FoodsDO>> foods = new HashMap<>();
        List<String> types = foodsDAO.getTypeName();
        types.forEach(obj -> {
            foods.put(obj, foodsDAO.getFoods(obj));
        });

        return foods;
    }
}
