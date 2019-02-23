package com.forum.service.userService.impl;

import com.forum.common.model.ResultModel;
import com.forum.common.model.Token;
import com.forum.common.utils.*;
import com.forum.pojo.vo.userControllerVo.LoginVo;
import com.forum.pojo.vo.userControllerVo.RegisterVo;
import com.forum.repository.domain.User;
import com.forum.repository.mapper.UserMapper;
import com.forum.service.userService.UserService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public ResultModel login(LoginVo loginVo) throws Exception {
        User user = new User();
        user.setAccount(loginVo.getAccount());
        user.setIsDel(false);
        PageList<User> users = userMapper.selectObjectListByWhere(user, ofPageBounds());
        if (CollectionUtil.isEmpty(users)) throw new Exception("账户不存在");
        if (!EncryptUtil.md5(loginVo.getPassword(), users.get(0).getSalt()).equals(users.get(0).getPassword()))
            throw new Exception("密码错误");
        Token token = new Token();
        token.setUserId(users.get(0).getPkUserId());
        return responseSuccess((Object) JWTUtil.sign(token));
    }

    @Override
    @Transactional
    public ResultModel register(RegisterVo registerVo) throws Exception {
        User user = new User();
        user.setAccount(registerVo.getAccount());
        user.setIsDel(false);
        if (userMapper.selectCountByWhere(user) != 0) throw new Exception("账号已被注册，请换账号");
        user.setName(registerVo.getName());
        user.setSalt(String.valueOf(RandomUtils.nextInt()));
        user.setPassword(EncryptUtil.md5(registerVo.getPassword(), user.getSalt()));
        user.setNickName(registerVo.getNickName());
        user.setSex(registerVo.getSex());
        user.setQq(registerVo.getQq());
        user.setPhone(registerVo.getPhone());
        if (userMapper.insertSelective(user) <= 0) throw new Exception("注册失败");
        return responseSuccess();
    }

    @Override
    @Transactional
    public ResultModel getUserInfo() {
        User user = userMapper.selectByPrimaryKey(TokenUtil.getUserId());
        if (ObjectUtil.isNull(user)) return ResultModel.getErrorResultModel("找不到用户信息");
        return responseSuccess(user);
    }

    @Override
    @Transactional
    public ResultModel getUserDetail() throws Exception {
        User user = new User();
        user.setPkUserId(TokenUtil.getUserId());
        user.setIsDel(false);
        PageList<User> users = userMapper.selectObjectListByWhere(user, ofPageBounds());
        if (CollectionUtil.isEmpty(users)) throw new Exception("查无此人");
        return responseSuccess(users.get(0));
    }
}
