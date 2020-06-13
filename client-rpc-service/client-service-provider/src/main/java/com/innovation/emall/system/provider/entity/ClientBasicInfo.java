package com.innovation.emall.system.provider.entity;

import com.innovation.emall.common.service.model.BaseDO;
import lombok.Data;

@Data
public class ClientBasicInfo extends BaseDO {
    private Long clientId;
    private String adminEmail;
    private String realName;
    private String shopName;
    private String clientServicePhone;
    private String addressDetail;
    private String provinceId;
    private String cityId;
    private String areaId;
    private String shopLongitude;
    private String shopLatitude;
    private String specialIdentificationImage;
    private String shopHeadImage;
    private String shopBankImage;
    private String shopInsideImage;
    private String companyWebsite;
    private String supplementary;
}
