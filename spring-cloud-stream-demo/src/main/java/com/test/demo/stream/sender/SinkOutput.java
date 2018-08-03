package com.test.demo.stream.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/8/3 16:26
 * @Update -
 * @Description
 */
public interface SinkOutput {

    String OUTPUT = "input";

    @Output(SinkOutput.OUTPUT)
    MessageChannel output();

}
