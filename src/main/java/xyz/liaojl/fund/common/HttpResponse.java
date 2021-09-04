package xyz.liaojl.fund.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class HttpResponse<T> {
    @Schema(name = "Status code", example = "0")
    private int code;
    @Schema(name = "Response message", example = "success")
    private String message;
    @Schema(name = "Response data", example = "{\"hello\": \"world\"}")
    private T data;

    public static <T> HttpResponse<T> success() {
        return success(null);
    }

    public static <T> HttpResponse<T> success(T data) {
        HttpResponse<T> response = new HttpResponse<>();
        response.setCode(0);
        response.setMessage("success");
        response.setData(data);
        return response;
    }

    public static <T> HttpResponse<T> error(String message) {
        HttpResponse<T> response = new HttpResponse<>();
        response.setCode(-1);
        response.setMessage(message);
        return response;
    }

    public static <T> HttpResponse<T> error(int code, String message) {
        HttpResponse<T> response = new HttpResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
