package com.huangtao.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * 将拦截器加入spring中
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean encodeFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new EncodeFilter());
        registration.addUrlPatterns("/*");
        registration.setName("EncodeFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}
