package com.ryan.atom.test.filter;


import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Administrator on 2017/12/21.
 */
@Component
@Order(10)
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--自定义filter init--");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--自定义filter doFilter before--");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("--自定义filter doFilter after--");
    }

    @Override
    public void destroy() {
        System.out.println("--自定义filter destroy--");
    }
}