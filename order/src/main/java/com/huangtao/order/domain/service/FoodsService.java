package com.huangtao.order.domain.service;

import com.huangtao.order.domain.dao.FoodsDAO;
import domains.order.dto.FoodsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodsService {

    @Autowired
    FoodsDAO foodsDAO;

    //获取一个商家所有在售的商品
    public List<FoodsDO> getFoods(String name){
        return foodsDAO.getFoods(name);
    }
}
