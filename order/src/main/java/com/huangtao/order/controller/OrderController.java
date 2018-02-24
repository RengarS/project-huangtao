package com.huangtao.order.controller;

import com.huangtao.order.service.OrderService;
import com.huangtao.order.domain.OrderDO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/addorder")
    public boolean addOrder(@RequestParam @NotBlank Object object){

        return orderService.saveOrder((OrderDO) object);
    }

    @GetMapping(value = "/getorder/{id}")
    public OrderDO getOrderDOById(@PathVariable("id") @NotBlank String id){

        System.out.println("Controller 层被调用了");
        System.out.println(id);
        OrderDO orderDO = orderService.getOrderDOById(id);
        System.out.println();
        return orderDO;
    }

    @PostMapping(value = "/updateorderstate/{id}")
    public boolean updateOrderstateById(@PathVariable("id") @NotBlank String id){

        return orderService.update(id);
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String testClass(){

        return "我是 order";
    }
}
