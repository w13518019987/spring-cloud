package com.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SentinelController {
    private static final Logger loger = LoggerFactory.getLogger(SentinelController.class);
    @GetMapping("/hello")
    @SentinelResource(value="hello",fallback = "sentinelFallback",defaultFallback="sentinelDefaultFallback")
    public String hello(){
        loger.info("hello");
        int i=1/0;
        return "hello Sentinel";
    }
    public String sentinelFallback(){
        loger.info("sentinelFallback");
        return "sentinelFallback";
    }
    public String sentinelDefaultFallback(){
        loger.info("sentinelDefaultFallback");
        return "sentinelDefaultFallback";
    }
}
