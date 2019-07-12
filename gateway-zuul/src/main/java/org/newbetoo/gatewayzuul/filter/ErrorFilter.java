package org.newbetoo.gatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anke
 * @date 2019/7/11 16:01
 **/
public class ErrorFilter extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(ErrorFilter.class);
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx=RequestContext.getCurrentContext();

        Throwable throwable=ctx.getThrowable();

        logger.error("Filter Error : {}",throwable.getCause().getMessage());
        return null;
    }
}
