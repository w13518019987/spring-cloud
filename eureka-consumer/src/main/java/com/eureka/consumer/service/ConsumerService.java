package com.eureka.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value="eureka-producer")
@FeignClient(value="${myFeign.value}")
@Component
public interface ConsumerService {
    @GetMapping("/getUserAll")
    public String get();

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable(value="id") Integer id);
}
