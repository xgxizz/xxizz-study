package com.xu.springbootrabbitmqprivider.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSendMessage_direct {

    @Autowired
    private SendMessageService_direct messageService;
    @Test
    public void testSendMsg() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            messageService.sendMsg("message "+ i);
        }

    }
    @Test
    public void testNonExchange(){
        messageService.TestNonExchangeMessageAck();
    }

    @Test
    public void testNonQueue(){
        messageService.TestNonQueueMessageAck();
    }
}
