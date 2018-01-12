package com.huangtao.order.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDO {
    private String id;
    //顾客id
    private String customerId;
    private String customerName;
    //订单状态
    private Short orderState;
    //订单的菜品
    private List<OrderFood> foods;
    //收货地址
    private String destination;
    //商店id
    private String storeId;
    private Date createTime;
    private Boolean isCancel;
    //总价
    private BigDecimal price;
    //用户备注
    private String comment;
}

@Data
class OrderFood {
    String orderId;
    String foodId;
    String foodNum;
}
