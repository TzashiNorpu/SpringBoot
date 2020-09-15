package com.tzashinorpu.dubboprovider.service;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;


@Component
@EnableDubbo
//@DubboService //将服务发布出去
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
