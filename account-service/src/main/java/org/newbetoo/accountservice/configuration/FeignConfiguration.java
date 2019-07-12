package org.newbetoo.accountservice.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anke
 * @date 2019/7/11 15:35
 **/
@Configuration
public class FeignConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return  Logger.Level.FULL;
    }
}
