package com.consumer.controller;

import com.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/")
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ConsumerService consumerService;
    @GetMapping("/get")
    public String get(){
        //String url = "http://localhost:8091/hello";
        String url = "http://spring-alibaba-producer/hello";
        ServiceInstance choose = loadBalancerClient.choose("spring-alibaba-producer");
//        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-producer");
//        System.out.println(serviceInstance);
//        namingService.getAllInstances()
        String result = restTemplate.getForObject(url, String.class);
        return result+":"+choose.getPort()+""+choose.getUri();
    }
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        String result = consumerService.findProducer();
        return result;
    }
    @GetMapping("/senTinel")
    public String senTinel(){
        String url = "http://spring-cloud-alibaba-sentinel/hello";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
