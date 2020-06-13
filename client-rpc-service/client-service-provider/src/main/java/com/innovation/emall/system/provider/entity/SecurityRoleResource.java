package com.innovation.emall.system.provider.entity;

import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SecurityRoleResource extends BaseDO {
    /**
     * 地区编码
     */
    @Column(name = "`role_id`")
    private Long roleId;


    @Column(name = "`resource_id`")
    private Long resourceId;

}