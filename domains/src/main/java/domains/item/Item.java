package domains.item;

import lombok.Data;


@Data
public class Item {
    private String id;
    private String name;
    private String img;
    private Integer sold;
    private Double price;
}
