package com.innovation.emall.common.service.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDO {
    private Long id;

    private Date createTime = new Date();

    private Date updateTime = new Date();

    private String creatorId = "1";

    private String updatorId = "1";

    private boolean deleteFlag =  false;
}
