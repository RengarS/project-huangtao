package com.huangtao.order.service;

import domains.order.OrderDO;
import com.huangtao.order.repo.OrderDAO;
import domains.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDao;

    public boolean saveOrder(OrderDO orderDO) {

        return orderDao.saveOrder(orderDO) > 0;
    }

    //测的是这个
    public OrderDTO getOrderDOById(String id) {
        System.out.println("SERVICE 层被调用了");
        return orderDao.getOrderDOById(id);
    }

    public boolean update(String id) {
        return orderDao.updateOrderStateById(id) > 0;
    }
}