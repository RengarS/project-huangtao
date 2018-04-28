package com.huangtao.order.service;

import com.huangtao.order.repo.ShopsDAO;
import domains.order.ShopsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopsService {

    @Autowired
    ShopsDAO shopsDAO;

    //获取所有商家信息

    public List<ShopsDO> getShops(){
        System.out.println(shopsDAO.getshops());
        return shopsDAO.getshops();
    }

}
