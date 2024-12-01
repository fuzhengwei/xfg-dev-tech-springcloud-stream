package cn.bugstack.xfg.dev.tech.infrastructure.adapter.repository;

import cn.bugstack.xfg.dev.tech.domain.adapter.event.UserMessageEvent;
import cn.bugstack.xfg.dev.tech.domain.adapter.repository.IUserRepository;
import cn.bugstack.xfg.dev.tech.domain.model.entity.UserEntity;
import cn.bugstack.xfg.dev.tech.infrastructure.event.EventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRepository extends UserMessageEvent implements IUserRepository {

    @Resource
    private EventPublisher publisher;

    @Override
    public void doSaveUser(UserEntity userEntity) {
        // 推送消息
        publisher.publish(this.topic(), this.buildEventMessage(UserMessageEvent.UserMessage.builder()
                .userId(userEntity.getUserId())
                .userName(userEntity.getUserName())
                .userType(userEntity.getUserTypeVO().getDesc())
                .build()));
    }

}
