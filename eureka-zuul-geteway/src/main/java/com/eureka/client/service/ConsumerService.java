package com.eureka.client.service;

/*
import org.springframework.cloud.openfeign.FeignClient;
*/
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value="eureka-client")
//@FeignClient("eurekaTest")
//@Component
public interface ConsumerService {
    @GetMapping("/helloEureka")
    public String get();

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable(value = "id") Integer id);

    @GetMapping("/client/helloEureka")
    public String index(@RequestParam("name") String name);
}
