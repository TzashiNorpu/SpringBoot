package com.tzashinorpu.dubboprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }

}
/*
https://github.com/apache/dubbo/releases/tag/dubbo-2.7.1
        zkclient' extension for 'org.apache.dubbo.remoting.zookeeper.ZookeeperTransporter' is removed from Dubbo 2.7.1, and 'curator' extension
        becomes the default extension. If you happen to config your application to use 'zkclient' explicitly, pls. switch to use 'curator' instead.*/
