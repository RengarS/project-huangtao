package com.huangtao.order.controller;

import com.huangtao.order.service.OrderService;
import domains.order.OrderDO;
import domains.order.OrderVO;
import domains.order.dto.OrderDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public OrderDTO getOrderDOById(@PathVariable("id") @NotBlank String id) {

        OrderDTO dto = orderService.getOrderDOById(id);
        return dto;
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
