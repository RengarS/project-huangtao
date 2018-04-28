package domains.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderAllDO {

    private String orderId;
    private String StoreName;
    private String orderState;
    private String StorePhotoUrl;
    private String orderCost;
    private String orderEndDate;
    private List<OrderFoods> list;


}
