package xyz.liaojl.fund.common;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public HttpResponse<Object> appException(CommonException e) {
        return HttpResponse.error(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public HttpResponse<Object> bindException(BindException e) {
        return HttpResponse.error(e.getMessage());
    }
}
