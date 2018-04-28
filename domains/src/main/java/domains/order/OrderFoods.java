package domains.order;

import lombok.Data;

@Data
public class OrderFoods {

    private String foodName;
    private String foodId;
    private int numb;
    private String price;
}
