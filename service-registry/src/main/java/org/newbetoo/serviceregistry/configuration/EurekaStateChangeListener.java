package org.newbetoo.serviceregistry.configuration;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Anke
 * @date 2019/7/10 18:00
 **/
@Component
public class EurekaStateChangeListener {

    private final Logger logger= LoggerFactory.getLogger(EurekaStateChangeListener.class);

    @EventListener
    public  void listen(EurekaInstanceCanceledEvent event){
         logger.debug(event.getServerId() + "\t"+event.getAppName()+" Service offline ");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instanceInfo=event.getInstanceInfo();
        logger.debug(instanceInfo.getAppName() +" Service online ");
    }
}
