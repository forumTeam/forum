package com.forum.common.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> builder() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/user/register", "anon");
        map.put("/user/getUserInfo", "anon");
        map.put("/user/login", "anon");
        map.put("/user/getRoles","anon");
        map.put("/user/counts", "anon");
        map.put("/user/logout", "logout");
        map.put("/login.jsp", "anon");
      //  map.put("/**", "authc");
        return map;
    }


}
