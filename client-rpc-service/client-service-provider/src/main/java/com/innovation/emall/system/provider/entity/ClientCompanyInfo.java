package com.innovation.emall.system.provider.entity;

import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

@Data
public class ClientCompanyInfo extends BaseDO {
    private Long clientId;

    private int bizLicenceType;

    private String companyName;

    private String companyAddress;

    private String provinceId;

    private String cityId;

    private String areaId;

    private String bizRunScope;

    private String socialCreditNo;

    private String runDueDate;

    private String socialCreditLicenceImage;

}
