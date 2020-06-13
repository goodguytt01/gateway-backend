package com.innovation.emall.system.provider.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`tb_sms_log`")
public class SmsLog {



    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 地区Id
     */
    @Column(name = "`mobile`")
    private String mobile;

    /**
     * 地区编码
     */
    @Column(name = "`content`")
    private String content;

    /**
     * 地区名
     */
    @Column(name = "`channel`")
    private String channel;

    /**
     */
    @Column(name = "`sms_module_id`")
    private Integer smsModuleId;


    @Column(name = "`delete_flag`")
    private boolean deleteFlag;

    @Column(name = "`creator_id`")
    private Long creatorId;


    @Column(name = "`updator_id`")
    private Long  updatorId;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`update_time`")
    private Date updateTime;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getSmsModuleId() {
        return smsModuleId;
    }

    public void setSmsModuleId(Integer smsModuleId) {
        this.smsModuleId = smsModuleId;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(Long updatorId) {
        this.updatorId = updatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}