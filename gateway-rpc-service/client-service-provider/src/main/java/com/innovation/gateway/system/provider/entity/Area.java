package com.innovation.gateway.system.provider.entity;

import javax.persistence.*;

@Table(name = "`tb_area`")
public class Area {
    /**
     * 地区Id
     */

    @Id
    @Column(name = "`areaId`")
    private Integer areaid;

    /**
     * 地区编码
     */
    @Column(name = "`areaCode`")
    private String areacode;

    /**
     * 地区名
     */
    @Column(name = "`areaName`")
    private String areaname;

    /**
     * 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    @Column(name = "`level`")
    private Byte level;

    /**
     * 城市编码
     */
    @Column(name = "`cityCode`")
    private String citycode;

    /**
     * 城市中心点（即：经纬度坐标）
     */
    @Column(name = "`center`")
    private String center;

    /**
     * 地区父节点
     */
    @Column(name = "`parentId`")
    private Integer parentid;

    /**
     * 获取地区Id
     *
     * @return areaId - 地区Id
     */
    public Integer getAreaid() {
        return areaid;
    }

    /**
     * 设置地区Id
     *
     * @param areaid 地区Id
     */
    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    /**
     * 获取地区编码
     *
     * @return areaCode - 地区编码
     */
    public String getAreacode() {
        return areacode;
    }

    /**
     * 设置地区编码
     *
     * @param areacode 地区编码
     */
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    /**
     * 获取地区名
     *
     * @return areaName - 地区名
     */
    public String getAreaname() {
        return areaname;
    }

    /**
     * 设置地区名
     *
     * @param areaname 地区名
     */
    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    /**
     * 获取地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     *
     * @return level - 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * 设置地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     *
     * @param level 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * 获取城市编码
     *
     * @return cityCode - 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置城市编码
     *
     * @param citycode 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    /**
     * 获取城市中心点（即：经纬度坐标）
     *
     * @return center - 城市中心点（即：经纬度坐标）
     */
    public String getCenter() {
        return center;
    }

    /**
     * 设置城市中心点（即：经纬度坐标）
     *
     * @param center 城市中心点（即：经纬度坐标）
     */
    public void setCenter(String center) {
        this.center = center;
    }

    /**
     * 获取地区父节点
     *
     * @return parentId - 地区父节点
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置地区父节点
     *
     * @param parentid 地区父节点
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}