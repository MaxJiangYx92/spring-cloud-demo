package com.test.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/13 13:47
 * @Update -
 * @Description
 */
public class AccessFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型，决定过滤器在请求的哪个生命周期中执行。
     * pre代表请求在被路由之前执行
     * routing:在路由请求时被调用
     * post:在routing和error之后被调用
     * error:处理请求发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序。当请求在一个阶段存在多个过滤器时候，需要根据这个方法返回值来依次执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断是否需要执行过滤器。true代表所有请求都会生效。实际开发中，利用这个函数指定过滤器的有效范围
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//
//        return requestContext.containsKey("error.status_code") && !requestContext.getBoolean("", false);

        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("access token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }

//        try {
//
//        } catch (ZuulException ex) {
//            requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            requestContext.set("error.message", ex.errorCause);
//            requestContext.set("error.exception", ex);
//        }

        logger.info("access token ok");
        return null;
    }
}
