//package com.test.demo.stream.receiver;
//
////import com.test.demo.stream.sender.SinkSender;
//
//import com.test.demo.stream.sender.SinkSender;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.messaging.Message;
//
///**
// * @author JiangYx
// * @Project
// * @Title
// * @Package
// * @Create 2018/7/29 11:43
// * @Update -
// * @Description
// */
//@EnableBinding(value = {Sink.class, SinkSender.class})//
//public class SinkReceiver {
//
//    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
//
//    @StreamListener(Sink.INPUT) //fun1
//    public void receive(Message<String> payload) {
//        logger.info("Receiver:{}", payload);
//    }
//}
