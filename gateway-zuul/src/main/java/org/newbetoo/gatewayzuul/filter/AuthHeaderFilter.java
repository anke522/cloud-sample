package org.newbetoo.gatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author Anke
 * @date 2019/7/11 16:58
 **/
public class AuthHeaderFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx=RequestContext.getCurrentContext();

        Object success=ctx.get("isSuccess");

        return success ==null || Boolean.parseBoolean(success.toString());
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("Authorization",System.getProperty("auth.token"));
        return null;
    }
}
