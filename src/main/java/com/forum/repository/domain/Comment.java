/*
* 文 件 名:  Comment.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:Comment
* 修 改 人:  teng
* 修改时间:  2019年02月21日
* 修改内容:  <修改内容>
*/
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    /**
     * 主键
     */
    private Long pkCommentId;

    /**
     * 评论人
     */
    private Long fkUserId;

    /**
     * 帖子id
     */
    private Long fkPostsId;

    /**
     * 评论内容
     */
    private String content;

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

    public Long getPkCommentId() {
        return pkCommentId;
    }

    public void setPkCommentId(Long pkCommentId) {
        this.pkCommentId = pkCommentId;
    }

    public Long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Long fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Long getFkPostsId() {
        return fkPostsId;
    }

    public void setFkPostsId(Long fkPostsId) {
        this.fkPostsId = fkPostsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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