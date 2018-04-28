package com.huangtao.order.controller;


import domains.order.ShopsDO;
import com.huangtao.order.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/shops/")
public class ShopsController {


    @Autowired
    ShopsService shopsService;

    @GetMapping("showshops")
    //获取商家列表
    public List<ShopsDO> showshops(){
        return shopsService.getShops();
    }
}
