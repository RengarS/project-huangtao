package domains.order;

import lombok.Data;

import java.util.List;

@Data
public class MenuItem {
    private String typeName;
    private List<FoodsDO> item;
}
