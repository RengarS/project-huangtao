package domains.order;

import lombok.Data;

@Data
public class NewFood {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String foodState;
    private String introduce;
    private String imageUrl;
}
