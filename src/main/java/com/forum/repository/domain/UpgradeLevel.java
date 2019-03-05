/*
* 文 件 名:  UpgradeLevel.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:UpgradeLevel
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class UpgradeLevel implements Serializable {
    /**
     * 等级升级申请单id
     */
    private Long pkUpgradeLevelId;

    /**
     * 用户
     */
    private Long fkUserId;

    /**
     * 等级
     */
    private Integer level;

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

    public Long getPkUpgradeLevelId() {
        return pkUpgradeLevelId;
    }

    public void setPkUpgradeLevelId(Long pkUpgradeLevelId) {
        this.pkUpgradeLevelId = pkUpgradeLevelId;
    }

    public Long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Long fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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