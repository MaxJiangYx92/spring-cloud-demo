package com.test.demo.stream;

import com.test.demo.stream.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
public class StreamApplicationTests {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoad(){
        String body="this is from sinkSender";
        sinkSender.output().send(MessageBuilder.withPayload(body).build());
    }
}
