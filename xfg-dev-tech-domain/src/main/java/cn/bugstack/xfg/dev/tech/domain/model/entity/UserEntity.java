package cn.bugstack.xfg.dev.tech.domain.model.entity;

import cn.bugstack.xfg.dev.tech.domain.model.valobj.UserTypeVO;
import lombok.Data;

@Data
public class UserEntity {

    private String userId;
    private String userName;
    private UserTypeVO userTypeVO;

}
