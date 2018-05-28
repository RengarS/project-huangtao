package com.huangtao.order.service;

import com.huangtao.order.repo.FoodsDAO;
import domains.order.*;
import domains.order.dto.Foods;
import org.apache.ibatis.annotations.Param;
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


    public boolean updatefood(@Param("foodId") String foodId, @Param("foodPrice") String foodPrice,@Param("foodName") String foodName,@Param("foodDesc") String foodDesc,@Param("imageUrl") String imageUrl,@Param("foodState") String foodState){
        return foodsDAO.updatefood(foodId,foodPrice,foodName,foodDesc,imageUrl,foodState)>0;
    }


    public OldFood getOldFoodById(String id){
        return foodsDAO.getOldFoodById(id);
    }

    public boolean delFood(@Param("foodId") String foodId,@Param("foodStoreId") String foodStoreId){
        return foodsDAO.delFood(foodId,foodStoreId)>0;
    }
}
