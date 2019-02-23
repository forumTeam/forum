package com.forum.service.userService;

import com.forum.common.model.ResultModel;
import com.forum.pojo.vo.userControllerVo.LoginVo;
import com.forum.pojo.vo.userControllerVo.RegisterVo;
import com.forum.service.BaseService;


public interface UserService extends BaseService {


    ResultModel login(LoginVo loginVo)throws Exception ;


    ResultModel register( RegisterVo registerVo) throws Exception;

    ResultModel getUserInfo() throws Exception;

    ResultModel getUserDetail()throws Exception ;
}
