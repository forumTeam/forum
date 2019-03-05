/*
* 文 件 名:  Message.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:Message
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    /**
     * 主键
     */
    private Long pkMessageId;

    /**
     * 发送者id
     */
    private Long fkAdministratorId;

    /**
     * 接收者id
     */
    private Long fkUserId;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否发送 0：未发送，1：已发送
     */
    private Boolean isDelivery;

    /**
     * 是否已读 0：未读，1：已读
     */
    private Boolean isRead;

    /**
     * 删除状态 0，未删除，1：管理员删除，2：业务员删除
     */
    private Boolean delStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 假删除 0：未删除，1：已删除
     */
    private Boolean isDel;

    private static final long serialVersionUID = 1L;

    public Long getPkMessageId() {
        return pkMessageId;
    }

    public void setPkMessageId(Long pkMessageId) {
        this.pkMessageId = pkMessageId;
    }

    public Long getFkAdministratorId() {
        return fkAdministratorId;
    }

    public void setFkAdministratorId(Long fkAdministratorId) {
        this.fkAdministratorId = fkAdministratorId;
    }

    public Long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Long fkUserId) {
        this.fkUserId = fkUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Boolean delStatus) {
        this.delStatus = delStatus;
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

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}