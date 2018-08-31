//package com.test.demo.zuul.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author JiangYx
// * @Project
// * @Title
// * @Package
// * @Create 2018/7/13 17:11
// * @Update -
// * @Description
// */
//@Component
//public class ThrowExceptionFilter extends ZuulFilter {
//
//    private static Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);
//
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        logger.info("this is a pre filter , it will throw a runtime exception");
//        throwException();
//        return null;
//    }
//
//    private void throwException() {
//        throw new RuntimeException("throw a test error...");
//    }
//}
