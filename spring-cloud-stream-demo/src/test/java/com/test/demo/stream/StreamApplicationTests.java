package com.test.demo.stream;

import com.test.demo.stream.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/30 22:48
 * @Update -
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {StreamApplication.class})
public class StreamApplicationTests {

    @Autowired
    private SinkSender sinkSender;

//    @Autowired
//    private MessageChannel input;

    @Test
    public void contextLoad() {
        String body = "this is from sinkSender";
//        sinkSender.output().send(MessageBuilder.withPayload(body).build());
//        sinkSender.sendMessage(body);
    }

//    @Test
//    public void contextLoad2() {
//        String body = "this is messagechannel";
//        input.send(MessageBuilder.withPayload(body).build());
//    }
}
