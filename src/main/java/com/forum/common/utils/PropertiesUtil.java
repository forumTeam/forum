package com.forum.common.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
* 功能描述: 获取全局通用的属性和值.
* @author 潘溢林
* 功能完成: 完成
* 最后修改时间: 2017/11/25 13:38
*/
public class PropertiesUtil {

    private static Map<String,String> propertyMap = new HashMap<>();

    static {
    	reload();
    }

    /**
    * 功能描述: 根据key获取propertyMap中值.
    * @author 潘溢林
    * 功能完成: 完成
    * 最后修改时间: 2017/11/25 13:38
    */
    public static String get(String key) {
        return propertyMap.get(key);
    }

    /**
    * 功能描述: 根据key获取propertyMap中值，如果没有则返回默认值.
    * @author 潘溢林
    * 功能完成: 完成
    * 最后修改时间: 2017/11/25 13:38
    */
    public static String get(String key, String defaultValue) {
        String value = propertyMap.get(key);
        return StringUtil.isEmpty(value) ? defaultValue : value;
    }
    
    /**
     * 功能描述: 重新从commons配置文件中读取配置信息.
     * @author 潘溢林
     * 功能完成: 完成
     * 最后修改时间: 2017/11/25 13:38
     */
    public synchronized static void reload(){
    	ResourceBundle properties = ResourceBundle.getBundle("commons");
        Enumeration<String> keys = properties.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            propertyMap.put(key,properties.getString(key));
        }
    }
}
