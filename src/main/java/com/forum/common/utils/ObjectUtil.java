package com.forum.common.utils;

import java.lang.reflect.Method;

public class ObjectUtil {


    /**
     * 对象是否为null
     *
     * @param obj
     * @return true:null,false:not null
     */
    public static boolean isNull(Object obj) {
        if (null == obj) {
            return true;
        }
        return false;
    }

    /**
     * 注解到对象复制，只复制能匹配上的方法。
     * @see把annotation对象属性复制给object对象
     * @param annotation
     * @param object
     * @updateMan
     */
    public static void annotationToObject(Object annotation, Object object) {
        if (annotation != null&& object!=null) {
            Class<?> annotationClass = annotation.getClass();
            Class<?> objectClass = object.getClass();
            for (Method m : objectClass.getMethods()) {
                if (StringUtil.startsWith(m.getName(), "set")) {
                    try {
                        String s = StringUtil.substring(m.getName(), 3);
                        // String s =
                        // StringUtil.uncapitalize(StringUtil.substring(m.getName(),
                        // 3));
                        Object obj = annotationClass.getMethod("get" + s).invoke(annotation);
                        if (obj != null && !"".equals(obj.toString())) {
                            m.invoke(object, obj);
                        }
                    } catch (Exception e) {
                        // 忽略所有设置失败方法
//						System.err.println(e.getMessage());
                    }
                }
            }
        }
    }
}
