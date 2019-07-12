package org.newbetoo.accountservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anke
 * @date 2019/7/10 16:25
 **/

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String hello(){
        return "hello world";
    }
}
