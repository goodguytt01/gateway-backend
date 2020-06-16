package com.innovation.gateway.system.provider.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

import java.util.Date;

@Data
public class ClientLawManInfo extends BaseDO {
    private Long clientId;
    private int lawManType;
    private int lawManLicenceType;
    private String lawManLicenceNo;
    private String lawManName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lawManLicenceStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lawManLicenceEndDate;
    private int lawManLicenceDueDateType;
    private String licenceImageFront;
    private String licenceImageBack;
    private String licenceImageHand;
}
