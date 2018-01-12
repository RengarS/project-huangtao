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
}
