package domains.responses;

import lombok.Data;

/**
 * object类返回值
 *
 * @param <T>
 */
@Data
public class ObjectResponse<T> {
    private int code = 200;
    private String msg;
    private T data;
}
