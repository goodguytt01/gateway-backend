package com.innovation.emall.system.api.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

public class ClientBasicInfoDTO implements java.io.Serializable{
    private Long clientId;
    @NotNull(message = "客户EMAIL不能为空")
    private String adminEmail;
    private String realName;
    @NotNull(message = "商户名称不能为空")
    private String shopName;
    @NotNull(message = "客服电话不能为空")
    private String clientServicePhone;
    @NotNull(message = "商户销售类目Id不能为空")
    private String shopCategoryId;
    @NotNull(message = "商户店铺具体地址不能为空")
    private String addressDetail;
    @NotNull(message = "商户店铺具体地址省份不能为空")
    private String provinceId;
    @NotNull(message = "商户店铺具体地址城市不能为空")
    private String cityId;
    @NotNull(message = "商户店铺具体地址区域不能为空")
    private String areaId;
    @NotNull(message = "商户店铺具体地址经度不能为空")
    private String shopLongitude;
    @NotNull(message = "商户店铺具体地址纬度不能为空")
    private String shopLatitude;
    private String specialIdentificationImage;
    private String shopHeadImage;
    private String shopBankImage;
    private String shopInsideImage;
    private String companyWebsite;
    private String supplementary;
    @NotNull(message = "客户Token不能为空")
    private String token;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getClientServicePhone() {
        return clientServicePhone;
    }

    public void setClientServicePhone(String clientServicePhone) {
        this.clientServicePhone = clientServicePhone;
    }

    public String getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(String shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
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

    public String getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(String shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

    public String getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(String shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public String getSpecialIdentificationImage() {
        return specialIdentificationImage;
    }

    public void setSpecialIdentificationImage(String specialIdentificationImage) {
        this.specialIdentificationImage = specialIdentificationImage;
    }

    public String getShopHeadImage() {
        return shopHeadImage;
    }

    public void setShopHeadImage(String shopHeadImage) {
        this.shopHeadImage = shopHeadImage;
    }

    public String getShopBankImage() {
        return shopBankImage;
    }

    public void setShopBankImage(String shopBankImage) {
        this.shopBankImage = shopBankImage;
    }

    public String getShopInsideImage() {
        return shopInsideImage;
    }

    public void setShopInsideImage(String shopInsideImage) {
        this.shopInsideImage = shopInsideImage;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getSupplementary() {
        return supplementary;
    }

    public void setSupplementary(String supplementary) {
        this.supplementary = supplementary;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
