package domains.responses;

import lombok.Data;

@Data
public class ErrorResponse {
    private int code;
    private String msg;

    public ErrorResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
