package org.newbetoo.gatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anke
 * @date 2019/7/11 15:53
 **/
public class IpFilter extends ZuulFilter {
    private final Logger logger= LoggerFactory.getLogger(IpFilter.class);

    public  IpFilter(){
        super();
    }

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
    public Object run()  {
        logger.debug("IpFilter excute");
        RequestContext ctx=RequestContext.getCurrentContext();

        return null;
    }
}
