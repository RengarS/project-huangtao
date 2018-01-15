package com.huangtao.order.controller;


import com.huangtao.order.OrderService;
import com.huangtao.order.domain.OrderDO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addorder")
    public boolean addOrder(@RequestParam @NotBlank Object object){

        return orderService.saveorder((OrderDO) object);
    }

    @GetMapping("/getorder/{id}")
    public OrderDO getOrderDOById(@PathVariable("id") @NotBlank String id){

        return orderService.getOrderDOById(id);
    }

    @PostMapping("/updateorderstate/{id}")
    public boolean updateOrderstateById(@PathVariable("id") @NotBlank String id){

        return orderService.update(id);
    }

}
