package domains.order.dto;

import lombok.Data;

@Data
public class Foods {
    private int Id;
    private String foodId;
    private String foodName;
    private String typeName;
    private String foodPrice;
    private String foodState;
}
