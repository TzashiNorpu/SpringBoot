package com.tzashi.norpu.hellostartertest.controller;

import com.tzashi.norpu.autoconfigure.HelloService;
//hello-starter
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHelloTzashiNorpu("haha");
    }
}
