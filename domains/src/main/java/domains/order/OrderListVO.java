package domains.order;

import lombok.Data;

@Data
public class OrderListVO {


    private String orderId;
    private String ordeCustomName;
    private String orderEndDate;
    private double cost;
    private String orderState;
    private String orderCustomTel;
}
