package com.test.demo.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/29 11:43
 * @Update -
 * @Description
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger logger= LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Receiver:{}",payload);
    }
}
