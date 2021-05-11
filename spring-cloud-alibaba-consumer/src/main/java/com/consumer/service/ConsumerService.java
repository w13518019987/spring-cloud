package com.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value="spring-alibaba-producer")
@Component
public interface ConsumerService {

    @GetMapping("/hello")
    public String findProducer();
}
