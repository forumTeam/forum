package com.forum.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpServletUtil {

    private HttpServletUtil(){

    }


    private HttpServletRequest getCurrentThreadRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    private HttpSession getCurrentThreadSession(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    private HttpServletResponse getCurrentThreadResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取当前线程request对象
     * @return
     */
    public static HttpServletRequest getRequest(){
        return new HttpServletUtil().getCurrentThreadRequest();
    }

    /**
     * 获取当前线程Response对象
     * @return
     */
    public static HttpServletResponse getResponse(){
        return new HttpServletUtil().getCurrentThreadResponse();
    }

    /**
     * 获取当前线程Session对象
     * @return
     */
    public static HttpSession getSession(){
        return new HttpServletUtil().getCurrentThreadSession();
    }

}
