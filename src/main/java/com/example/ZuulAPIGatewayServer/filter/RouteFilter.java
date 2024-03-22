package com.example.ZuulAPIGatewayServer.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RouteFilter extends ZuulFilter {
    private static Logger Log = LoggerFactory.getLogger(preFilter.class);

    @Override
    public String filterType() {
        return "route";
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
        System.out.println("RouteFilter: " + request.getMethod() + " request to " + request.getRequestURL().toString());
        Log.info("RouteFilter: " + String.format("%s request to %s",request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
