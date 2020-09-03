package com.tz.autoconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootTest
class AutoconfigApplicationTests {
    @Autowired
    ApplicationContext applicationContext;
    @Test
    void contextLoads() {
        CharacterEncodingFilter characterEncodingFilter = (CharacterEncodingFilter)applicationContext.getBean("characterEncodingFilter");
        System.out.println(characterEncodingFilter);
    }

}
