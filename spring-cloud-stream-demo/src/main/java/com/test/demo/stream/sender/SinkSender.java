package com.test.demo.stream.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/30 22:45
 * @Update -
 * @Description
 */
@EnableBinding(value = {MySource.class})
public class SinkSender {

//    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);

    /**
     * fun1
     */
//    @Output(Sink.INPUT)
//    MessageChannel output();

    @Bean
    @InboundChannelAdapter(value = MySource.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

    @Transformer(inputChannel = MySource.OUTPUT, outputChannel = MySource.OUTPUT)
//    @Transformer(inputChannel = Sink.INPUT, outputChannel = Sink.INPUT)
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

    @Bean
    @InboundChannelAdapter(value = MySource.OUTPUT_1, poller = @Poller(fixedDelay = "3000"))
    public MessageSource<Date> timerMessageSource1() {
        return () -> new GenericMessage<>(new Date());
    }

    @Transformer(inputChannel = MySource.OUTPUT_1, outputChannel = MySource.OUTPUT_1)
    public Object transform1(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd").format(message);
    }

}
