package com.test.demo.springcloudribbon.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/3 17:16
 * @Update -
 * @Description
 */
@WebFilter(filterName = "hystrixRequestContextServletFilter", urlPatterns = "/*", asyncSupported = true)
public class HystrixRequestContextServletFilter implements Filter {
    static HystrixRequestContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init method");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter doFilter method");
        if (context == null) {
            context = HystrixRequestContext.initializeContext();
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
//            context.shutdown();
        }
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy method");
    }
}
