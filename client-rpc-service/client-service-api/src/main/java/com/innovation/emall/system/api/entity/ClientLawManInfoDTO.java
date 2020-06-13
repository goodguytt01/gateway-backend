package com.innovation.emall.system.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

public class ClientLawManInfoDTO implements Serializable {
    private Long clientId;
    private int lawManType;
    private int lawManLicenceType;
    private String lawManLicenceNo;
    private String lawManName;
    private Date lawManLicenceStartDate;
    private Date lawManLicenceEndDate;
    private int lawManLicenceDueDateType;
    private String licenceImageFront;
    private String licenceImageBack;
    private String licenceImageHand;
    private String token;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getLawManType() {
        return lawManType;
    }

    public void setLawManType(int lawManType) {
        this.lawManType = lawManType;
    }

    public int getLawManLicenceType() {
        return lawManLicenceType;
    }

    public void setLawManLicenceType(int lawManLicenceType) {
        this.lawManLicenceType = lawManLicenceType;
    }

    public String getLawManLicenceNo() {
        return lawManLicenceNo;
    }

    public void setLawManLicenceNo(String lawManLicenceNo) {
        this.lawManLicenceNo = lawManLicenceNo;
    }

    public String getLawManName() {
        return lawManName;
    }

    public void setLawManName(String lawManName) {
        this.lawManName = lawManName;
    }

    public Date getLawManLicenceStartDate() {
        return lawManLicenceStartDate;
    }

    public void setLawManLicenceStartDate(Date lawManLicenceStartDate) {
        this.lawManLicenceStartDate = lawManLicenceStartDate;
    }

    public Date getLawManLicenceEndDate() {
        return lawManLicenceEndDate;
    }

    public void setLawManLicenceEndDate(Date lawManLicenceEndDate) {
        this.lawManLicenceEndDate = lawManLicenceEndDate;
    }

    public int getLawManLicenceDueDateType() {
        return lawManLicenceDueDateType;
    }

    public void setLawManLicenceDueDateType(int lawManLicenceDueDateType) {
        this.lawManLicenceDueDateType = lawManLicenceDueDateType;
    }

    public String getLicenceImageFront() {
        return licenceImageFront;
    }

    public void setLicenceImageFront(String licenceImageFront) {
        this.licenceImageFront = licenceImageFront;
    }

    public String getLicenceImageBack() {
        return licenceImageBack;
    }

    public void setLicenceImageBack(String licenceImageBack) {
        this.licenceImageBack = licenceImageBack;
    }

    public String getLicenceImageHand() {
        return licenceImageHand;
    }

    public void setLicenceImageHand(String licenceImageHand) {
        this.licenceImageHand = licenceImageHand;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
