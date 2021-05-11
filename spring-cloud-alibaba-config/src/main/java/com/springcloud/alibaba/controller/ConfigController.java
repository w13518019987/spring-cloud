package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/config")
@RefreshScope
public class ConfigController {
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;
    @GetMapping("/get")
    public boolean get(){
        System.out.println(useLocalCache);
        return useLocalCache;
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
