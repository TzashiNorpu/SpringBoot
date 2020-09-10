package com.tzashinorpu.mq;

import com.tzashinorpu.mq.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
/*
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		System.out.println("创建完成");*/

//		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //创建绑定规则

		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));

        //amqpAdmin.de
    }

    @Test
    public void createFanoutExchange() {
        amqpAdmin.declareExchange(new FanoutExchange("amqpadmin.fanoutExchange"));
        System.out.println("创建完成");

        amqpAdmin.declareQueue(new Queue("fanout.queue1",true));
        amqpAdmin.declareQueue(new Queue("fanout.queue2",true));
        amqpAdmin.declareQueue(new Queue("fanout.queue3",true));
        amqpAdmin.declareQueue(new Queue("fanout.queue4",true));
        //创建绑定规则

        amqpAdmin.declareBinding(new Binding("fanout.queue1", Binding.DestinationType.QUEUE,"amqpadmin.fanoutExchange","amqp.hello1",null));
        amqpAdmin.declareBinding(new Binding("fanout.queue2", Binding.DestinationType.QUEUE,"amqpadmin.fanoutExchange","amqp.hello2",null));
        amqpAdmin.declareBinding(new Binding("fanout.queue3", Binding.DestinationType.QUEUE,"amqpadmin.fanoutExchange","amqp.hello3",null));
        amqpAdmin.declareBinding(new Binding("fanout.queue4", Binding.DestinationType.QUEUE,"amqpadmin.fanoutExchange","amqp.hello4",null));

        //amqpAdmin.de
    }
    @Test
    public void sendToFanoutExchange() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第二个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("amqpadmin.fanoutExchange", "amqp.haha", map);

    }

    @Test
    public void createTopicExchange() {
        amqpAdmin.declareExchange(new TopicExchange("amqpadmin.TopicExchange"));
        System.out.println("创建完成");

        amqpAdmin.declareQueue(new Queue("tpoic.queue1",true));
        amqpAdmin.declareQueue(new Queue("tpoic.queue2",true));
        amqpAdmin.declareQueue(new Queue("tpoic.queue3",true));
        amqpAdmin.declareQueue(new Queue("tpoic.queue4",true));
        //创建绑定规则

        amqpAdmin.declareBinding(new Binding("tpoic.queue1", Binding.DestinationType.QUEUE,"amqpadmin.TopicExchange","amqp.#",null));
        amqpAdmin.declareBinding(new Binding("tpoic.queue2", Binding.DestinationType.QUEUE,"amqpadmin.TopicExchange","#.hello",null));
        amqpAdmin.declareBinding(new Binding("tpoic.queue3", Binding.DestinationType.QUEUE,"amqpadmin.TopicExchange","amqp.hello3",null));
        amqpAdmin.declareBinding(new Binding("tpoic.queue4", Binding.DestinationType.QUEUE,"amqpadmin.TopicExchange","amqp.hello4",null));

        //amqpAdmin.de
    }
    @Test
    public void sendToTopicExchange() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("msg", "这是第三个消息");
        map1.put("data", Arrays.asList("helloworld3", 123, true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("amqpadmin.TopicExchange", "amqp.hello", map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("msg", "这是第四个消息");
        map2.put("data", Arrays.asList("helloworld4", 123, true));
        rabbitTemplate.convertAndSend("amqpadmin.TopicExchange", "amqp.hello3", map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("msg", "这是第五个消息");
        map3.put("data", Arrays.asList("helloworld5", 123, true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("amqpadmin.TopicExchange", "amqp.hello", map3);

    }
    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("amqpadmin.exchange", "amqp.haha", new Book("西游记", "吴承恩"));

    }

    //接受数据,如何将数据自动的转为json发送出去
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("amqpadmin.queue");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
    }


}
