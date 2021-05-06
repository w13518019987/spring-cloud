package com.eureka.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class EurekaClientController {
    @GetMapping("/helloEureka")
    public String helloEureka(String name, HttpServletRequest request){
        System.out.println("hello Eureka"+"地址:【"+request.getServerPort()+"】"+name);
        return "hello Eureka"+"地址:【"+request.getServerPort()+"】"+name;
    }
}
