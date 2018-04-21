package com.huangtao.order.controller;

import com.huangtao.order.service.OrderService;
import com.huangtao.order.domain.OrderDO;
import domains.order.dto.OrderDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/addorder")
    public boolean addOrder(@RequestParam @NotBlank Object object) {

        return orderService.saveOrder((OrderDO) object);
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
