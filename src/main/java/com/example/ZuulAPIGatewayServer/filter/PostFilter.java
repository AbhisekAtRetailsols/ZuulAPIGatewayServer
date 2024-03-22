package com.example.ZuulAPIGatewayServer.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

public class PostFilter extends ZuulFilter {
    private static Logger Log = LoggerFactory.getLogger(preFilter.class);

    @Override
    public String filterType() {
        return "post";
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
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        System.out.println("PostFilter: response's Context type is " + response.toString());
        Log.info("PostFilter: " + String.format("response's Context type is %s", response.toString()));
        return null;
    }
}