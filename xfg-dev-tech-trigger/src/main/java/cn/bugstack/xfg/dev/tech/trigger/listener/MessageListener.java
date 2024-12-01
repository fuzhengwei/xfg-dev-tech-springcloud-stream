package cn.bugstack.xfg.dev.tech.trigger.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding({Sink.class})
public class MessageListener {

    @StreamListener(Sink.INPUT)
    public void onMessage(String message) {
        log.info("接收消息:{}", message);
    }

}
