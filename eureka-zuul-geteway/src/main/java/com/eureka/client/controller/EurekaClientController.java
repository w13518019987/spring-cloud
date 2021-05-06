package com.eureka.client.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/client")
public class EurekaClientController {

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public String index(){
        return "index";
    }
   /* @GetMapping("/helloEureka")
    public String helloEureka(String name, HttpServletRequest request){
        System.out.println("hello Eureka"+"地址:【"+request.getServerPort()+"】"+name);
        return "hello Eureka"+"地址:【"+request.getServerPort()+"】"+name;
    }
    @GetMapping("/client")
    public String client(String name, HttpServletRequest request){
        System.out.println("hello zuul"+"地址:【"+request.getServerPort()+"】"+name);
        return "hello zuul"+"地址:【"+request.getServerPort()+"】"+name;
    }
    @GetMapping("/client1")
    public String client1(String name, HttpServletRequest request){
        System.out.println("hello zuul"+"地址:【"+request.getServerPort()+"】"+name);
        return "hello zuul"+"地址:【"+request.getServerPort()+"】"+name;
    }
    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        System.out.println(name);
        return name;
    }*/
}
