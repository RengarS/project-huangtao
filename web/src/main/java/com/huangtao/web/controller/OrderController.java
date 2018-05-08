package com.huangtao.web.controller;

import domains.order.*;
import domains.order.dto.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 获取商家列表
     * @return
     */
    @RequestMapping(value = "/shops", method = RequestMethod.GET)
    public List<ShopsDO> get(){
        return restTemplate.getForObject("http://order/shops/showshops", List.class);
    }

    /**
     * 获取一个商家的在售商品
     * @param name
     * @return
     */
    @RequestMapping("/foods/{name}")
    public OrderMenu getFoods(@PathVariable String name) {
        return restTemplate.getForObject("http://order/foods/showfoods/" + name, OrderMenu.class);
    }

    /**
     * 增加订单
     * @param orderVO
     * @return
     */
    @RequestMapping("/addorder")
    public boolean addOrder(@RequestBody OrderVO orderVO){
        return restTemplate.postForObject("http://order/order/addorder",orderVO,boolean.class);
    }

    /**
     * 获取一个用户的订单
     * @param name
     * @return
     */
    @RequestMapping("/getorders/{name}")
    public List<OrderAllDO> getOrders(@PathVariable String name){
        return restTemplate.getForObject("http://order/order/getorders/"+name,List.class);
    }


    /**
     * 更新订单状态，结束订单，收货
     * @param id
     * @return
     */
    @RequestMapping("/updateOrderstateToEnd/{id}")
    public boolean updateOrderstateToEnd(@PathVariable String id){
        return restTemplate.getForObject("http://order/order/updateOrderstateToEnd/"+id,boolean.class);
    }

    /**
     * PC端获取一个商家的所有商品
     * @param id
     * @return
     */
    @RequestMapping("/getAllFoods/{id}")
    public List<Foods> getAlllFoods(@PathVariable String id){
        return restTemplate.getForObject("http://order/foods/getfoods/"+id,List.class);
    }

    /**
     * PC端更新一个商品信息
     * @param newFood
     * @return
     */
    @PostMapping("/updatefood")
    public boolean updateFood(@RequestBody NewFood newFood){
        return restTemplate.postForObject("http://order/foods/updatefood",newFood,boolean.class);
    }

    /**
     * PC端获取要更新的老商品信息
     * @param id
     * @return
     */
    @GetMapping("/getoldfood/{id}")
    public OldFood getOldFoodById(@PathVariable String id){
        System.out.println("访问到了web！");
        return restTemplate.getForObject("http://order/foods/getoldfood/"+id,OldFood.class);
    }
}
