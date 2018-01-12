package domains.responses;

import lombok.Data;

/**
 * object类返回值
 *
 * @param <T>
 */
@Data
public class ObjectResponse<T> {
    private int code;
    private String msg;
    private T data;
}
