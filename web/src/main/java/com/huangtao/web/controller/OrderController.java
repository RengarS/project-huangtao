package com.huangtao.web.controller;

import domains.order.*;
import domains.order.dto.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 获取商家列表
     *
     * @return
     */
    @RequestMapping(value = "/shops", method = RequestMethod.GET)
    public List<ShopsDO> get() {
        return restTemplate.getForObject("http://order/shops/showshops", List.class);
    }

    /**
     * 获取一个商家的在售商品
     *
     * @param name
     * @return
     */
    @RequestMapping("/foods/{name}")
    public OrderMenu getFoods(@PathVariable String name) {
        return restTemplate.getForObject("http://order/foods/showfoods/" + name, OrderMenu.class);
    }

    /**
     * 增加订单
     *
     * @param orderVO
     * @return
     */
    @RequestMapping("/addorder")
    public boolean addOrder(@RequestBody OrderVO orderVO) {
        return restTemplate.postForObject("http://order/order/addorder", orderVO, boolean.class);
    }

    /**
     * 获取一个用户的订单
     *
     * @param name
     * @return
     */
    @RequestMapping("/getorders/{name}")
    public List<OrderAllDO> getOrders(@PathVariable String name) {
        return restTemplate.getForObject("http://order/order/getorders/" + name, List.class);
    }


    /**
     * 更新订单状态，商家接单，配送中
     * @param orderId
     * @return
     */
    @GetMapping("/updateOrderStateToGo/{orderId}")
    public boolean updateOrderStateToGo(@PathVariable String orderId){
        return restTemplate.getForObject("http://order/order/updateorderstate/"+orderId,boolean.class);
    }
    /**
     * 更新订单状态，结束订单，收货
     *
     * @param id
     * @return
     */
    @RequestMapping("/updateOrderstateToEnd/{id}")
    public boolean updateOrderstateToEnd(@PathVariable String id) {
        return restTemplate.getForObject("http://order/order/updateOrderstateToEnd/" + id, boolean.class);
    }

    /**
     * PC端获取一个商家的所有商品
     *
     * @param id
     * @return
     */
    @RequestMapping("/getAllFoods/{id}")
    public List<Foods> getAlllFoods(@PathVariable String id) {
        return restTemplate.getForObject("http://order/foods/getfoods/" + id, List.class);
    }

    /**
     * PC端更新商品信息
     * @param foodId
     * @param foodPrice
     * @return
     */

    @GetMapping("/updatefood")
    public boolean updateFood(@RequestParam("foodId") String foodId, @RequestParam("foodPrice") String foodPrice,@RequestParam("foodName") String foodName,@RequestParam("foodDesc") String foodDesc,@RequestParam("imageUrl") String imageUrl,@RequestParam("foodState") String foodState) {
        return restTemplate.getForObject("http://order/foods/updatefoods?foodId="+foodId+"&foodPrice="+foodPrice+"&foodName="+foodName+"&foodState="+foodState+"&foodDesc="+foodDesc+"&imageUrl="+imageUrl, boolean.class);
    }

    /**
     * PC端获取要更新的老商品信息
     * @param id
     * @return
     */
    @GetMapping("/getoldfood/{id}")
    public OldFood getOldFoodById(@PathVariable String id) {
        return restTemplate.getForObject("http://order/foods/getoldfood/" + id, OldFood.class);
    }

    /**
     * PC端获取所有的未完成订单
     * @param storeId
     * @return
     */
    @GetMapping("/getOrderByStoreId/{storeId}")
    public List<OrderListVO> getOrderByStoreId(@PathVariable String storeId){
        return restTemplate.getForObject("http://order/order/getordersPC/"+storeId,List.class);
    }

    /**
     *
     * @param orderId
     * @return
     */
    @GetMapping("/getOrderByOrderId/{orderId}")
    List<OrderFoods> getOrderByOrderId(@PathVariable("orderId") String orderId ){
        return restTemplate.getForObject("http://order/order/getOrderByOrderId/"+orderId,List.class);
    }

}
