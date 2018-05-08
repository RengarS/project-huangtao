package com.huangtao.order.service;

import com.huangtao.order.repo.FoodsDAO;
import domains.order.*;
import domains.order.dto.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FoodsService {

    @Autowired
    private FoodsDAO foodsDAO;

    //获取一个商家所有在售的商品
    public List<FoodsDO> getFoods(String name) {
        return foodsDAO.getFoods(name);
    }

    public OrderMenu getTypeFoods(String store) {
        OrderMenu menu = new OrderMenu();
        menu.setMenu(new LinkedList<>());
        List<String> types = foodsDAO.getTypeName(store);
        types.forEach(obj -> {
            MenuItem menuItem = new MenuItem();
            menuItem.setTypeName(obj);
            menuItem.setItem(foodsDAO.getFoodsByType(obj, store));
            menu.getMenu().add(menuItem);
        });
        return menu;
    }

    public List<Foods> getAllFoods(String id) {
        int code = 1;
        List<Foods> foodsList = foodsDAO.getAllFoods(id);
        for (Foods foods : foodsList) {
            foods.setId(code++);
        }
        return foodsList;
    }


    public boolean updatefood(NewFood newFood){
        return foodsDAO.updatefood(newFood)>0;
    }


    public OldFood getOldFoodById(String id){
        return foodsDAO.getOldFoodById(id);
    }
}
