package domains.responses;

import lombok.Data;

import java.util.Collection;

@Data
/**
 * 集合类返回值
 */
public class CollectionResponse<T> {
    private int code;
    private String msg;
    private Collection<T> data;
}
