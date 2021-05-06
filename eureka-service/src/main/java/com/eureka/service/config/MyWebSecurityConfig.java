package com.eureka.service.config;

import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;*/

/*@EnableWebSecurity*/
//@Configuration
public class MyWebSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf否则eureka客户端注册不上
        http.httpBasic().and().authorizeRequests().anyRequest().permitAll().and().csrf().disable();
      *//*  http.csrf().ignoringAntMatchers("/eureka/**");*//*
      *//*  super.configure(http);*//*
    }*/
}
