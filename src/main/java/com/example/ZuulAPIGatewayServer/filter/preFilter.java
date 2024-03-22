package com.example.ZuulAPIGatewayServer.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class preFilter extends ZuulFilter {
    private static Logger Log = LoggerFactory.getLogger(preFilter.class);

    @Override
    public String filterType() {
        return "pre";
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = (HttpServletRequest) ctx.getRequest();
        System.out.println("PreFilter: " + request.getMethod() + "request to " + request.getRequestURL().toString());
        Log.info("PreFilter: " + String.format("%s request to %s",request.getMethod(), request.getRequestURL().toString()));
    return null;
    }
}
