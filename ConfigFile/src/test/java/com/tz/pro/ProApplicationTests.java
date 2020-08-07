package com.tz.pro;

import com.tz.pro.bean.Person;
import com.tz.pro.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ProApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext applicationContext;
    @Test
    void test(){
        System.out.println(applicationContext.containsBean("helloService02"));
    }
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
