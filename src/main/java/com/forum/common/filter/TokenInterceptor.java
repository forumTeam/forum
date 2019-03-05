package com.forum.common.filter;

import com.forum.common.constant.ErrorCodeEnum;
import com.forum.common.model.ResultModel;
import com.forum.common.model.Token;
import com.forum.common.utils.GsonUtil;
import com.forum.common.utils.JWTUtil;
import com.forum.common.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenInterceptor implements HandlerInterceptor {


    private static final Logger logger = Logger.getLogger(TokenInterceptor.class);
    private static final String CHARACTER_ENCODING = "UTF-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tokenString = request.getHeader("token");
        /* 1、判断在请求头中是否包含token，不包含token或是空值，返回无效的token。*/
        if(StringUtil.isEmpty(tokenString)) return responseMessage(response);
        /* 2、判断token是否有效。*/
        Token token = JWTUtil.unsign(tokenString, Token.class);
        if(null == token) return responseMessage(response);
        /* 3、将user添加到request中，供请求的方法进行判断权限。*/
        request.setAttribute("token", token);
        return true;
    }

    private boolean responseMessage(HttpServletResponse response) {
        String json = GsonUtil.toJson(ResultModel.getErrorResultModel(ErrorCodeEnum.INVALID_TOKEN));
        try {
            response.setHeader("Content-Type", "application/json");
            response.setCharacterEncoding(CHARACTER_ENCODING);
            response.getWriter().print(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            logger.error("关闭Response输出流异常!!!",e);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
