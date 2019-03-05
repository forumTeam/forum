package com.forum.common.utils;

import com.forum.common.model.Token;

public final class TokenUtil {


    private final static String TOKEN="token";


    /**
     * 获取当但请求Token
     * @return
     */
    public static Token getToken(){
        return (Token) HttpServletUtil.getRequest().getAttribute(TOKEN);
    }


    /**
     * 获取当但请求Token  中userId
     * @return
     */
    public static Long getUserId() {
        return getToken().getUserId();
    }
}
