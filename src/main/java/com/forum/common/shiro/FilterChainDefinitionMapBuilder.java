package com.forum.common.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> builder() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/shiro/logout", "logout");
        map.put("/**", "authc");
        return map;
    }


}
