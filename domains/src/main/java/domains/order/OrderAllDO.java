package domains.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderAllDO {

    private String orderId;   //订单ID
    private String StoreName;  //店铺名称
    private String orderState; //订单状态
    private String StorePhotoUrl; //商家图片地址
    private String orderCost; //订单总价
    private String orderEndDate; //订单结束时间
    private List<OrderFoods> list; //订单内容


}
