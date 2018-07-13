package com.test.demo.zuul.processor;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/13 16:52
 * @Update -
 * @Description
 */
public class ZuulFilterProcessor extends FilterProcessor {
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException ex) {
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.set("failed.filter", filter);
            throw ex;
        }
    }
}
