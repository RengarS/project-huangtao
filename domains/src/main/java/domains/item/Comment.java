package domains.item;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private String username = "11";
    private String headImg = "22";
    private Date time = new Date();
    private String detail = "111";
}
