package com.innovation.gateway.system.provider.entity;


import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

@Data
public class ClientLoginLog extends BaseDO {

    private String channel;

    private int type;

    private Long clientId;

}
