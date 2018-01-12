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

/**
 * 请求执行异常，则返回错误信息
 */
@ControllerAdvice
public class WebExceptionHandler {

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
