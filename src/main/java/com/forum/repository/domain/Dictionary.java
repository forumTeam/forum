
package com.forum.repository.domain;

import java.io.Serializable;
import java.util.Date;

public class Dictionary implements Serializable {
    /**
     * 字典id
     */
    private Long pkDictionaryId;

    /**
     * 数据库表名
     */
    private String tableName;

    /**
     * 数据库字段
     */
    private String fieldName;

    /**
     * 数据库枚举值
     */
    private Integer dictionaryValue;

    /**
     * 数据库枚举显示文本
     */
    private String dictionaryText;

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

    public Long getPkDictionaryId() {
        return pkDictionaryId;
    }

    public void setPkDictionaryId(Long pkDictionaryId) {
        this.pkDictionaryId = pkDictionaryId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public Integer getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(Integer dictionaryValue) {
        this.dictionaryValue = dictionaryValue;
    }

    public String getDictionaryText() {
        return dictionaryText;
    }

    public void setDictionaryText(String dictionaryText) {
        this.dictionaryText = dictionaryText == null ? null : dictionaryText.trim();
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