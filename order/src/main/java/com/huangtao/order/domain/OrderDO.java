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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Short getOrderState() {
        return orderState;
    }

    public void setOrderState(Short orderState) {
        this.orderState = orderState;
    }

    public List<OrderFood> getFoods() {
        return foods;
    }

    public void setFoods(List<OrderFood> foods) {
        this.foods = foods;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getCancel() {
        return isCancel;
    }

    public void setCancel(Boolean cancel) {
        isCancel = cancel;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

@Data
class OrderFood {
    String orderId;
    String foodId;
    String foodNum;
}
