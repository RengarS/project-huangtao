package domains.order;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderFood implements Serializable {
    String orderId;
    String foodId;
    String foodName;
}
