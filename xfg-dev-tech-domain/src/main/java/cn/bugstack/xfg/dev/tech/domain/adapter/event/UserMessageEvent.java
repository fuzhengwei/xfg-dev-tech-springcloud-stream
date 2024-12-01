package cn.bugstack.xfg.dev.tech.domain.adapter.event;

import cn.bugstack.xfg.dev.tech.types.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * 用户推送实践消息的聚合
 */
public class UserMessageEvent extends BaseEvent<UserMessageEvent.UserMessage> {

    @Value("${mq.topic.user}")
    private String topic;

    @Override
    public EventMessage<UserMessage> buildEventMessage(UserMessage data) {
        return EventMessage.<UserMessage>builder()
                .id(RandomStringUtils.randomNumeric(11))
                .timestamp(new Date())
                .data(data)
                .build();
    }

    @Override
    public String topic() {
        return topic;
    }

    /**
     * 要推送的事件消息，聚合到当前类下。
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserMessage {
        private String userId;
        private String userName;
        private String userType;
    }

}
