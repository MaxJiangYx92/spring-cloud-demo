package com.test.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/13 16:49
 * @Update -
 * @Description
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {
    @Override
    public String filterType() {
        return super.filterType();
    }

    @Override
    public int filterOrder() {
//        return super.filterOrder();
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        //判断：处理来自post过滤器引发的异常
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
        if (failedFilter != null && "post".equals(failedFilter.filterType())) {
            return true;
        }
        return false;
//        return super.shouldFilter();
    }

    @Override
    public Object run() {
        return super.run();
    }
}
