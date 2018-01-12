package com.huangtao.web.filter;

import com.alibaba.fastjson.JSON;
import domains.responses.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@ControllerAdvice
public class WebExceptionHandler {
//
//    private static final ImmutableMap<Class<? extends Throwable>, ErrorResponse> EXCEPTION_HANDLER;
//
//    static {
//        final ImmutableMap.Builder<Class<? extends Throwable>, ErrorResponse> builders = ImmutableMap.builder();
//        builders.put(Exception.class, new ErrorResponse(444, "服务异常，请稍候再试"));
//        EXCEPTION_HANDLER = builders.build();
//    }

    @ExceptionHandler
    public void exceptionHappens(Exception e, HttpServletRequest request, HttpServletResponse response) {
        String json = null;
        try {
            json = JSON.toJSONString(new ErrorResponse(444, new String("请稍候再试".getBytes(), "UTF-8")));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(json);
            writer.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
