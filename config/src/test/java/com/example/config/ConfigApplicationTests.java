package com.example.config;

import com.example.config.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ConfigApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean b = ioc.containsBean("helloService02");
        System.out.println(b);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
