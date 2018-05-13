package com.huangtao.order.controller;

import com.huangtao.order.service.OrderService;
import domains.order.OrderAllDO;
import domains.order.OrderFoods;
import domains.order.OrderListVO;
import domains.order.OrderVO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private  OrderService orderService;

    /**
     *
     * @param orderVO
     * @return
     */
    @PostMapping(value = "/addorder")
    public boolean addOrder(@RequestBody @NotBlank OrderVO orderVO) {
        return orderService.addOrder(orderVO);
    }


    /**
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/getorders/{name}")
    public List<OrderAllDO> getOrderDOById(@PathVariable("name") @NotBlank String name) {
        List<OrderAllDO> orderAllDOS = orderService.getOrderDOByName(name);
        return orderAllDOS;
    }


    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/updateorderstate/{id}")
    public boolean updateOrderstateById(@PathVariable("id") @NotBlank String id) {
        return orderService.update(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/updateOrderstateToEnd/{id}")
    public boolean updateOrderstateToEnd(@PathVariable("id") @NotBlank String id) {
        return orderService.update(id);
    }

    /**
     * 获取一个商家的所有未完成的订单
     * @param storeId
     * @return
     */
    @GetMapping(value ="/getordersPC/{storeId}")
    List<OrderListVO> getOrderByStoreId( @PathVariable("storeId") String storeId){
        return orderService.getOrderByStoreId(storeId);
    }

    @GetMapping("/getOrderByOrderId/{orderId}")
    List<OrderFoods> getOrderByOrderId(@PathVariable("orderId")  String orderId){
        return orderService.getOrderFoodByOrderId(orderId);
    }


}
