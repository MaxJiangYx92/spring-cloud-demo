package com.test.demo.stream.consumer.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/7 16:10
 * @Update -
 * @Description
 */
public interface MySink {
    String INPUT = "input";

    @Input(MySink.INPUT)
    SubscribableChannel input();

    String INPUT1 = "input1";

    @Input(MySink.INPUT1)
    SubscribableChannel input1();
}
