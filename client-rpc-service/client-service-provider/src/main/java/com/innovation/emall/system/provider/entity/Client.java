package com.innovation.emall.system.provider.entity;


import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

@Data
public class Client extends BaseDO {

    private String mobile;

    private String password;

    private int status;

}
