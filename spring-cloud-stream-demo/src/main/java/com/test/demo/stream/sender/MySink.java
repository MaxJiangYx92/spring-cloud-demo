package com.test.demo.stream.sender;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/7 9:52
 * @Update -
 * @Description
 */
public interface MySink {

    String INPUT_1 = "sinkA";

    @Input(MySink.INPUT_1)
    SubscribableChannel input1();

}
