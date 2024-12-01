package cn.bugstack.xfg.dev.tech.domain;

import cn.bugstack.xfg.dev.tech.domain.model.entity.UserEntity;
import cn.bugstack.xfg.dev.tech.domain.model.valobj.UserTypeVO;
import cn.bugstack.xfg.dev.tech.domain.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void test_register() throws InterruptedException {
        while (true) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId("10001");
            userEntity.setUserName("小傅哥");
            userEntity.setUserTypeVO(UserTypeVO.T8);

            userService.register(userEntity);
            Thread.sleep(1500);
        }

    }

}
