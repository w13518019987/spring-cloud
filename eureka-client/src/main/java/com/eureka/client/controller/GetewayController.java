package com.eureka.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class GetewayController {
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        String name = request.getServerName();
        String post = request.getServerPort()+"";
        String uri = request.getRequestURI();
        return uri+"-->"+name+"--->"+post;
    }
}
