package domains.responses;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * map类返回值
 *
 * @param <K>
 * @param <V>
 */
@Data
public class MapResponse<K, V> {
    private int code = 200;
    private String msg;
    private Map<K, V> data;

    public MapResponse() {
        this.data = new HashMap<>();
    }
}
