package com.test.demo.stream.sender;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/30 22:45
 * @Update -
 * @Description
 */
@EnableBinding(Sink.class)
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();

}
