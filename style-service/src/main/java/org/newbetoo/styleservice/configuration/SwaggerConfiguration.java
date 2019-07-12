package org.newbetoo.styleservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static  springfox.documentation.builders.PathSelectors.regex;

import java.util.Date;

/**
 * @author Anke
 * @date 2019/7/10 17:22
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public static final String DEAFULT_INCLUDE_PATTERN="/user/.*";

    private final Logger log= LoggerFactory.getLogger((SwaggerConfiguration.class));

    @Bean
    public Docket swaggerSpringfoxDocket(){
        log.debug("Starting Swagger");
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();

        ApiInfo apiInfo=new ApiInfo("API接口测试","Description","version","termsOfServiceUrl","contact","","");

        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .genericModelSubstitutes(ResponseEntity.class)
                .forCodeGeneration(true)
                .directModelSubstitute(java.time.LocalDate.class,String.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class,Date.class)
                .select()
                .paths(regex(DEAFULT_INCLUDE_PATTERN))
                .build();
        stopWatch.stop();
        log.debug("Start Swagger in {} ms",stopWatch.getTotalTimeMillis());

        return  docket;
    }
}
