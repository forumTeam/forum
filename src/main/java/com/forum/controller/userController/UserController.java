package com.forum.controller.userController;


import com.alibaba.fastjson.JSON;
import com.forum.common.listener.rabbitmq.util.QueueEnum;
import com.forum.common.listener.rabbitmq.util.TeskExchangeUtil;
import com.forum.common.model.ResultModel;
import com.forum.common.shiro.ShrioRealm;
import com.forum.pojo.vo.userControllerVo.LoginVo;
import com.forum.pojo.vo.userControllerVo.RegisterVo;
import com.forum.repository.domain.User;
import com.forum.service.userService.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShrioRealm shrioRealm;

    @ApiOperation(value = "登陆", notes = "靳旺")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultModel login(@RequestBody @Valid LoginVo loginVo) throws Exception {
        return shrioRealm.login(loginVo.getAccount(), loginVo.getPassword());
    }


    @ApiOperation(value = "注册", notes = "靳旺")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultModel register(@RequestBody @Valid RegisterVo registerVo) throws Exception {
        return userService.register(registerVo);
    }


    @ApiOperation(value = "获取用户信息", notes = "靳旺")
    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public ResultModel getUserInfo() throws Exception {
        return userService.getUserInfo();
    }

    @ApiOperation(value = "获取用户详细信息", notes = "靳旺")
    @RequestMapping(value = "getUserDetail", method = RequestMethod.POST)
    public ResultModel getUserDetail() throws Exception {
        return userService.getUserDetail();
    }

    @ApiOperation(value = "获取用帖子与动态数", notes = "靳旺")
    @RequestMapping(value = "count", method = RequestMethod.POST)
    public ResultModel count() throws Exception {
        return userService.count();
    }


}
