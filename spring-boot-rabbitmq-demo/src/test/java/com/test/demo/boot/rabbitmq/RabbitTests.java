package com.test.demo.boot.rabbitmq;

import com.test.demo.boot.rabbitmq.productor.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/7/24 14:01
 * @Update -
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitTests {
    @Autowired
    private Sender sender;

    @Test
    public void hello() {
        sender.send();
    }
}
