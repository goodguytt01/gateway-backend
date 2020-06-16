package com.innovation.gateway.system.provider.entity;

import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SecurityRole extends BaseDO {
    /**
     * 地区编码
     */
    @Column(name = "`name`")
    private String name;

}