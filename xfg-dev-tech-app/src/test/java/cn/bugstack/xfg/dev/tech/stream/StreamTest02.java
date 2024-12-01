package cn.bugstack.xfg.dev.tech.stream;

import cn.bugstack.xfg.dev.tech.types.MyProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest02 {

    @Autowired
    private MessageProducer producer;

    @Test
    public void test_publish() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            producer.send("mq 消息，哈喽哇！");
        }

        new CountDownLatch(1).await();
    }

    @Component
    @EnableBinding(MyProcessor.class)
    static class MessageProducer {

        @Autowired
        private MyProcessor source;

        public void send(String message) {
            source.output().send(MessageBuilder.withPayload(message).build());
        }

    }

    @Component
    @EnableBinding({MyProcessor.class})
    static class MessageConsumer {
        @StreamListener(MyProcessor.INPUT)
        public void onMessage(String message) {
            System.out.println("@测试 -> " + message);
        }

    }

}
