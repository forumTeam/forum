package com.forum.common.utils;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;

public class StringUtil extends StringUtils {


    public static boolean isNull(String str){
        if (str == null || str.equals("")){
            return  true;
        }
        return false;
    }
}
