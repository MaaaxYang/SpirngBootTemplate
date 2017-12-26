package com.ryan.atom.test.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/21.
 */
@Component
@Order(11)
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--自定义filter2 init--");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--自定义filter2 doFilter before--");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("--自定义filter2 doFilter after--");
    }

    @Override
    public void destroy() {
        System.out.println("--自定义filter2 destroy--");
    }
}
