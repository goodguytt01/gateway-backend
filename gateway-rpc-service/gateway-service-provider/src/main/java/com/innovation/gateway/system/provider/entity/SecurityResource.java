package com.innovation.gateway.system.provider.entity;

import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class SecurityResource extends BaseDO {
    /**
     * 地区Id
     */
    @Column(name = "`url`")
    private String url;

    /**
     * 地区编码
     */
    @Column(name = "`name`")
    private String name;

}