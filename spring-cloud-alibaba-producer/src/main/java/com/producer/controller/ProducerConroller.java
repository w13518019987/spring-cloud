package com.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class ProducerConroller {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return "Producer Hello:"+request.getRequestURI()+"："+request.getServerPort();
    }
}
