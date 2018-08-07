package com.test.demo.stream.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/3 14:34
 * @Update -
 * @Description
 */
public interface MySource {

    //发送队列1
    String OUTPUT = "output";

    @Output(MySource.OUTPUT)
    MessageChannel output();

    //发送队列1
    String OUTPUT_1 = "output1";

    @Output(MySource.OUTPUT_1)
    MessageChannel output1();


}
