package com.huangtao.order;

import com.huangtao.order.domain.OrderDO;
import com.huangtao.order.repo.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDao;

    public boolean saveorder(OrderDO orderDO){
        return  orderDao.saveorder(orderDO)>0;
    }

    public OrderDO getOrderDOById(String id){
        return orderDao.getOrderDOById(id);
    }

    public boolean update(String id){
        return orderDao.updateOrderStateById(id)>0;
    }
}
