package com.tzashinorpu.dubboconsumer;

import com.tzashinorpu.dubboconsumer.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DubboConsumerApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {

        userService.hello();
    }

}
