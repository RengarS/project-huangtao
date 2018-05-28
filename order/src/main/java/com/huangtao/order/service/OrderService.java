package com.huangtao.order.service;

import com.huangtao.order.repo.OrderDAO;
import domains.order.*;
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


    public List<OrderAllDO> getOrderDOByName(String name) {
        List<OrderAllDO> orderAllDOS = orderDao.getOrderDOByName(name);
        for (OrderAllDO orderAllDO : orderAllDOS) {
            for (OrderFoods orderFoods : orderAllDO.getList()) {
                double cost = orderFoods.getNumb() * Double.parseDouble(orderFoods.getPrice());
                orderAllDO.setOrderCost(String.valueOf(cost));
            }
        }
        return orderAllDOS;
    }

    public boolean update(String id) {
        return orderDao.updateOrderStateById(id) > 0;
    }

    public boolean addOrder(OrderVO orderVO) {
        //随机生成UUID来当做orderId
        String orderId = UUID.randomUUID().toString();
        orderVO.setOrderId(orderId);
        orderDao.addOrder(orderVO);
        for (OrderFoods obj : orderVO.getList()) {
            obj.setOrderId(orderId);
            orderDao.addOrderTemp(obj);
        }
        //订单增加完成，增加商家的销售数量
        orderDao.addSales(orderVO.getOrderStoreName());

        return true;
    }


    public boolean updateToEnd(String id) {
        return orderDao.updateOrderStateEnd(id) > 0;
    }


    public List<OrderListVO> getOrderByStoreId(String storeId) {
        List<OrderListVO> listVOS =  orderDao.getOrderByStoreId(storeId);
        for (OrderListVO orderListVO :listVOS ) {
            double cost =0;
            cost = cost+Double.valueOf(orderDao.getOrderFoodByOrderId(orderListVO.getOrderId()).getPrice())* Double.valueOf(orderDao.getOrderFoodByOrderId(orderListVO.getOrderId()).getNumb());
            orderListVO.setCost(cost);
        }

        return listVOS;
    }


    public List<OrderFoods> getOrderFoodByOrderId(String orderId){
        return orderDao.getOrderFoodsByOrderId(orderId);
    }



}
