package com.huangtao.user.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {

    private String id;

    private String customerName;

    private Short customerState;

    private String customerQQ;

    private String customerTEL;

    private String customerMail;

    private String customerPassword;

    private Date createTime;

    private Boolean isDel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Short getCustomerState() {
        return customerState;
    }

    public void setCustomerState(Short customerState) {
        this.customerState = customerState;
    }

    public String getCustomerQQ() {
        return customerQQ;
    }

    public void setCustomerQQ(String customerQQ) {
        this.customerQQ = customerQQ;
    }

    public String getCustomerTEL() {
        return customerTEL;
    }

    public void setCustomerTEL(String customerTEL) {
        this.customerTEL = customerTEL;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }
}
