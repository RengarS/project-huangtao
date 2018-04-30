package com.huangtao.order.controller;

import com.huangtao.order.service.OrderService;
import domains.order.OrderAllDO;
import domains.order.OrderDO;
import domains.order.OrderVO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/addorder")
    public boolean addOrder(@RequestBody @NotBlank OrderVO orderVO) {
        return orderService.addOrder(orderVO);
    }

    @GetMapping(value = "/getorder/{id}")
    public List<OrderAllDO> getOrderDOById(@PathVariable("id") @NotBlank String id) {
        List<OrderAllDO> orderAllDOS = orderService.getOrderDOById(id);
        return orderAllDOS;
    }

    @PostMapping(value = "/updateorderstate/{id}")
    public boolean updateOrderstateById(@PathVariable("id") @NotBlank String id) {

        return orderService.update(id);
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public OrderDO testClass() {

        return new OrderDO();
    }
}
