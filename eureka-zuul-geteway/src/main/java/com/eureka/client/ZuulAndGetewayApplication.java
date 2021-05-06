package com.eureka.client;

import com.eureka.client.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient //eureka客户端注解支持
//@EnableDiscoveryClient
//@EnableZuulProxy
@RestController
/*@EnableFeignClients*/
public class ZuulAndGetewayApplication {

    @Resource
    DiscoveryClient discoveryClient;

  /*  @Autowired
    private ConsumerService consumerService;*/
    @GetMapping("/hello")
    public String hello() {
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            System.out.println(s);
            List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
            for (ServiceInstance insatance : instances) {
                System.out.println(insatance.getHost());
                System.out.println(insatance.getInstanceId());
                System.out.println(insatance.getServiceId());
                System.out.println(insatance.getUri());
            }
        }
        return "hello zuul";
    }
    public static void main(String[] args) {
        SpringApplication.run(ZuulAndGetewayApplication.class, args);
    }

}
