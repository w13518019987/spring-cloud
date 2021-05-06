package com.eureka.consumer.controller;

import com.eureka.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ConsumerService consumerService;


    @GetMapping("/info")
    public String info(String name){
        // 要加 @LoadBalanced //负载均衡 注解
        String url = "http://eureka-client/helloEureka?name="+name;
        //String url = "http://localhost:8081/helloEureka";
        String result = restTemplate.getForEntity(url,String.class).getBody();
        return result;
    }
    @GetMapping("/invoke/{method}/{id}")
    public String invoke(@PathVariable String method,@PathVariable Integer id){
        String url = "http://eureka-hystrix/"+method+"/"+id;
        String result = restTemplate.getForEntity(url,String.class).getBody();
        return result;
    }
    @GetMapping("/openFeign")
    public String openFeign(){
        String result = consumerService.get();
        return result;
    }
    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable Integer id){
        String result = consumerService.getUser(id);
        return result;
    }
}
