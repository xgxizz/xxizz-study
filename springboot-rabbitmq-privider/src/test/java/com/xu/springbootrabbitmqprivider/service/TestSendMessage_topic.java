package com.xu.springbootrabbitmqprivider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSendMessage_topic {

    @Autowired
    private SendMessageService_topic messageService;
    @Test
    public void testSendMsg() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            messageService.sendTopicMessage1();
            messageService.sendTopicMessage2();
        }

    }
}
