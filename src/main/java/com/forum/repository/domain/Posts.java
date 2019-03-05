/*
* 文 件 名:  Posts.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:Posts
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class Posts implements Serializable {
    /**
     * 主键
     */
    private Long pkPostsId;

    /**
     * 创建人
     */
    private Long fkUserId;

    /**
     * 创建人
     */
    private Long fkAdministratorId;

    /**
     * 帖子标题
     */
    private String postsTitle;

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
     * 帖子内容
     */
    private String postsContent;

    private static final long serialVersionUID = 1L;

    public Long getPkPostsId() {
        return pkPostsId;
    }

    public void setPkPostsId(Long pkPostsId) {
        this.pkPostsId = pkPostsId;
    }

    public Long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Long fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Long getFkAdministratorId() {
        return fkAdministratorId;
    }

    public void setFkAdministratorId(Long fkAdministratorId) {
        this.fkAdministratorId = fkAdministratorId;
    }

    public String getPostsTitle() {
        return postsTitle;
    }

    public void setPostsTitle(String postsTitle) {
        this.postsTitle = postsTitle == null ? null : postsTitle.trim();
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

    public String getPostsContent() {
        return postsContent;
    }

    public void setPostsContent(String postsContent) {
        this.postsContent = postsContent == null ? null : postsContent.trim();
    }
}