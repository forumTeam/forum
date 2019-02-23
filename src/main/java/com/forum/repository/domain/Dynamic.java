
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class Dynamic implements Serializable {
    /**
     * 主键
     */
    private Long pkDynamicId;

    /**
     * 创建人
     */
    private Long fkUserId;

    /**
     * 标题
     */
    private String dynamicTitle;

    /**
     * 创建人
     */
    private Long fkAdministratorId;

    /**
     * 假删除 0：未删除，1：已删除
     */
    private Boolean isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 内容
     */
    private String dynamicContent;

    private static final long serialVersionUID = 1L;

    public Long getPkDynamicId() {
        return pkDynamicId;
    }

    public void setPkDynamicId(Long pkDynamicId) {
        this.pkDynamicId = pkDynamicId;
    }

    public Long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Long fkUserId) {
        this.fkUserId = fkUserId;
    }

    public String getDynamicTitle() {
        return dynamicTitle;
    }

    public void setDynamicTitle(String dynamicTitle) {
        this.dynamicTitle = dynamicTitle == null ? null : dynamicTitle.trim();
    }

    public Long getFkAdministratorId() {
        return fkAdministratorId;
    }

    public void setFkAdministratorId(Long fkAdministratorId) {
        this.fkAdministratorId = fkAdministratorId;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
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

    public String getDynamicContent() {
        return dynamicContent;
    }

    public void setDynamicContent(String dynamicContent) {
        this.dynamicContent = dynamicContent == null ? null : dynamicContent.trim();
    }
}