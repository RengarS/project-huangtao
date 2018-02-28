package domains.order.dto;

import domains.order.OrderFood;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDTO implements Serializable {
    private String orderId;
    private String orderCustomId;
    private String orderCustomName;
    private String orderState;
    private String storeAddrAll;
    private String endAddrAll;
    private String orderStoreId;
    private String orderStoreName;
    private List<OrderFood> foods;
}

