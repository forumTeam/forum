package com.forum.service.userService;

import com.forum.common.model.ResultModel;
import com.forum.pojo.vo.userControllerVo.LoginVo;
import com.forum.pojo.vo.userControllerVo.RegisterVo;
import com.forum.service.BaseService;


public interface UserService extends BaseService {


    /**
     * 注册
     * @param registerVo
     * @return
     * @throws Exception
     */
    ResultModel register( RegisterVo registerVo) throws Exception;

    /**
     * 获取用户信息
     * @return
     * @throws Exception
     */
    ResultModel getUserInfo() throws Exception;

    /**
     * 获取用户详细信息
     * @return
     * @throws Exception
     */
    ResultModel getUserDetail()throws Exception ;

    /**
     * 获取用帖子与动态数
     * @return
     * @throws Exception
     */
    ResultModel count()throws Exception;

    /**
     * 获取权限
     * @return
     * @throws Exception
     */
    ResultModel getRoles();
}
