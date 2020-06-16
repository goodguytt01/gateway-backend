package com.innovation.emall.system.api.entity;

import lombok.Data;

import java.io.Serializable;

public class ClientCompanyInfoDTO implements Serializable {
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

    private String token;


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getBizLicenceType() {
        return bizLicenceType;
    }

    public void setBizLicenceType(int bizLicenceType) {
        this.bizLicenceType = bizLicenceType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getBizRunScope() {
        return bizRunScope;
    }

    public void setBizRunScope(String bizRunScope) {
        this.bizRunScope = bizRunScope;
    }

    public String getSocialCreditNo() {
        return socialCreditNo;
    }

    public void setSocialCreditNo(String socialCreditNo) {
        this.socialCreditNo = socialCreditNo;
    }

    public String getRunDueDate() {
        return runDueDate;
    }

    public void setRunDueDate(String runDueDate) {
        this.runDueDate = runDueDate;
    }

    public String getSocialCreditLicenceImage() {
        return socialCreditLicenceImage;
    }

    public void setSocialCreditLicenceImage(String socialCreditLicenceImage) {
        this.socialCreditLicenceImage = socialCreditLicenceImage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
