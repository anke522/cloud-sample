package org.newbetoo.accountservice.util;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Anke
 * @date 2019/7/10 16:49
 **/
public class ServiceInfoUtil implements ApplicationListener<WebServerInitializedEvent> {
    private static  WebServerInitializedEvent event;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        ServiceInfoUtil.event=event;
    }

    public  static  int getPort(){
        int port=event.getSource().getPort();
        return  port;
    }
}
