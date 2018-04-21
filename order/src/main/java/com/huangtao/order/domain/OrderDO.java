package com.huangtao.order.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDO implements Serializable {
    private String orderId;
    private String orderCustomId;
    private String orderCustomName;
    private String orderState;
    private String storeAddrAll;
    private String endAddrAll;
    private String orderStoreId;
    private String orderStoreName;
}

