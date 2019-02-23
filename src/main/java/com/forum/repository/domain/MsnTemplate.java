/*
* 文 件 名:  MsnTemplate.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:MsnTemplate
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class MsnTemplate implements Serializable {
    /**
     * 短信模板id
     */
    private Long pkMsnTemplateId;

    /**
     * 短信标题
     */
    private String title;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 是否全局模板 0：否，1：是
     */
    private Boolean isGlobal;

    /**
     * 创建人
     */
    private Long creator;

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

    public Long getPkMsnTemplateId() {
        return pkMsnTemplateId;
    }

    public void setPkMsnTemplateId(Long pkMsnTemplateId) {
        this.pkMsnTemplateId = pkMsnTemplateId;
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

    public Boolean getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(Boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
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