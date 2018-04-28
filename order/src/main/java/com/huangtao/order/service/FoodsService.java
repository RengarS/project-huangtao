package com.huangtao.order.service;

import com.huangtao.order.repo.FoodsDAO;
import domains.order.MenuItem;
import domains.order.OrderMenu;
import domains.order.FoodsDO;
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
        types.forEach(obj->{
            MenuItem menuItem = new MenuItem();
            menuItem.setTypeName(obj);
            menuItem.setItem(foodsDAO.getFoodsByType(obj,store));
            menu.getMenu().add(menuItem);
        });
        return  menu;
    }
}
