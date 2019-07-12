package org.newbetoo.gatewayzuul.configuration;

import org.newbetoo.gatewayzuul.filter.IpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anke
 * @date 2019/7/11 15:57
 **/
@Configuration
public class FilterConfiguration {

    @Bean
    public IpFilter ipFilter(){
        return  new IpFilter();
    }
}
