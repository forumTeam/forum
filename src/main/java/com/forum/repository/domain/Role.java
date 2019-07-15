/*
* 文 件 名:  Role.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:Role
* 修 改 人:  Administrator
* 修改时间:  2019年07月09日
* 修改内容:  <修改内容>
*/
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    /**
     * 角色id
     */
    private Long pkRoleId;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 权限
     */
    private String permissionids;

    /**
     * 假删除 0：未删除，1：已删除
     */
    private Boolean isDel;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getPkRoleId() {
        return pkRoleId;
    }

    public void setPkRoleId(Long pkRoleId) {
        this.pkRoleId = pkRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPermissionids() {
        return permissionids;
    }

    public void setPermissionids(String permissionids) {
        this.permissionids = permissionids == null ? null : permissionids.trim();
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}