package com.forum.common.constant;

/**
 * 错误码枚举
 */
public enum ErrorCodeEnum {

    OK(0, "SUCCESS"),
    FAILED(1, "FAILED"),
    INVALID_TOKEN(2, "TOKEN无效或过期");


    int code;

    String message;


    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
