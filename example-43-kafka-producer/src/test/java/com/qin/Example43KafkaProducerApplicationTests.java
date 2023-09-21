package com.qin;

import com.qin.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootTest
class Example43KafkaProducerApplicationTests {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    void contextLoads() {
    }

    //异步发送
    @Test
    void testAsyncSend(){
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        kafkaTemplate.send("testTopic",user.toString());
    }


    //同步发送
    @Test
    void testSyncSend() throws InterruptedException, ExecutionException, TimeoutException {
        User user = new User();
        user.setName("李四");
        user.setAge(30);

        ListenableFuture<SendResult<String, Object>> sendResult = kafkaTemplate
                .send("testTopic", user.toString());

        SendResult<String, Object> result = sendResult.get(3, TimeUnit.SECONDS);
        System.out.println("监听到的结果-------"+result.getProducerRecord().value());
        System.out.println("写入的分区-------"+result.getRecordMetadata().partition());

    }

}
