package com.xu.springbootrabbitmqconsumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver2 {
 
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver2消费者收到消息  : " + testMessage.toString());
    }
}