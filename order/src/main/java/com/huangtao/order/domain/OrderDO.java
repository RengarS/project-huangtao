package com.huangtao.order.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDO {
    private String  orderId;
    private String orderCustomId;
    private String orderCustomName;
    private String orderState;
    private String storeAddrAll;
    private String endAddrAll;
    private String orderStoreId;
    private String orderStoreName;
    private List<OrderFood> foods;

}

@Data
class OrderFood {
    String orderId;
    String foodId;
    String foodName;
}
