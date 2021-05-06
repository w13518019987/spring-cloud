package com.eureka.client.filter;

//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

//import javax.servlet.http.HttpServletRequest;

//@Component
public class MyZuulFilter /*extends ZuulFilter */{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

   /* @Override
    public String filterType() {
        // 在路由之前进行过滤
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        logger.info("请求URI：{}，HTTP Method：{}，请求IP：{}", uri, method, host);
        return null;
    }*/
}
