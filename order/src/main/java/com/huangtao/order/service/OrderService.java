package com.huangtao.order.service;

import com.huangtao.order.repo.OrderDAO;
import domains.order.OrderAllDO;
import domains.order.OrderDO;
import domains.order.OrderFoods;
import domains.order.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDao;

    public boolean saveOrder(OrderDO orderDO) {

        return orderDao.saveOrder(orderDO) > 0;
    }

    //测的是这个
    public List<OrderAllDO> getOrderDOById(String id) {
        return orderDao.getOrderDOById(id);
    }

    public boolean update(String id) {
        return orderDao.updateOrderStateById(id) > 0;
    }

    public boolean addOrder(OrderVO orderVO){
       String orderId = UUID.randomUUID().toString();
       orderVO.setOrderId(orderId);
       orderDao.addOrder(orderVO);
        for (OrderFoods obj:orderVO.getList()
             ) {
            obj.setOrderId(orderId);
            orderDao.addOrderTemp(obj);
        }
        return true;
    }
}
