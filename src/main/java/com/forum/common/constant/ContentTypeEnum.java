package com.forum.common.constant;

/**
 * 功能描述：HTTP 请求报文类型
 * @author lizhangxiong 2016年8月9日
 */
public enum ContentTypeEnum {

    JSON("application/json;charset=UTF-8"), 
    XML("text/Xml;charset=UTF-8"),
    FORM("application/x-www-form-urlencoded;charset=UTF-8");

    private String value;

    ContentTypeEnum(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
