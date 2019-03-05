/*
* 文 件 名:  MsnRecord.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:MsnRecord
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class MsnRecord implements Serializable {
    /**
     * 短信记录id
     */
    private Long pkMsnRecordId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 备注
     */
    private String note;

    /**
     * 发送人
     */
    private Long sender;

    /**
     * 发送人类型 0：系统，1：管理员，2：员工
     */
    private Long senderType;

    /**
     * 接收人
     */
    private Long receiver;

    /**
     * 接收人类型 0：合伙人，1：客户，2：客户组
     */
    private Integer receiverType;

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

    public Long getPkMsnRecordId() {
        return pkMsnRecordId;
    }

    public void setPkMsnRecordId(Long pkMsnRecordId) {
        this.pkMsnRecordId = pkMsnRecordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getSenderType() {
        return senderType;
    }

    public void setSenderType(Long senderType) {
        this.senderType = senderType;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public Integer getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(Integer receiverType) {
        this.receiverType = receiverType;
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