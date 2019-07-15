package com.forum.service.roleService.impl;

import com.forum.common.model.ResultModel;
import com.forum.common.utils.*;
import com.forum.pojo.roleControllerVo.*;
import com.forum.repository.domain.Role;
import com.forum.repository.domain.User;
import com.forum.repository.mapper.UserMapper;
import com.forum.repository.mapper.RoleMapper;
import com.forum.service.roleService.RoleService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public ResultModel getRoles(SelectRoleVo selectRoleVo) throws Exception {
        Role role = new Role();
        if (selectRoleVo.getMyRole() != null) role.setIsDel(false);
        PageList<Role> roles = roleMapper.selectObjectListByWhere(role, ofPageBounds(selectRoleVo));
        return responseSuccess(roles, roles.getPaginator());
    }

    @Override
    @Transactional
    public ResultModel getRoleInfo(GetRoleInfoVo getRoleInfoVo) throws Exception {
        Role role = roleMapper.selectByPrimaryKey(getRoleInfoVo.getPkRoleId());
        if (ObjectUtil.isNull(role)) throw new Exception("未查到该角色");
        return responseSuccess(role);
    }

    @Override
    @Transactional
    public ResultModel addRole(AddRoleVo addRoleVo) throws Exception {

        User user = userMapper.selectByPrimaryKey(TokenUtil.getUserId());
        if (ObjectUtil.isNull(user)) throw new Exception("找不到用户");

        Role role = new Role();
        ObjectUtil.annotationToObject(addRoleVo, role);
//        role.setFkUserId(TokenUtil.getUserId());

        if (roleMapper.insertSelective(role) <= 0) throw new Exception("添加失败");
        return responseSuccess();
    }

    @Override
    public ResultModel delRole(DelRoleVo delRoleVo) throws Exception {

        if (delRoleVo.getPkRoleId() == null) throw new Exception("角色id不能为空");

        Role role = roleMapper.selectByPrimaryKey(delRoleVo.getPkRoleId());
        if (ObjectUtil.isNull(role)) throw new Exception("查无此角色");

        role.setIsDel(true);
        if (roleMapper.updateByPrimaryKeySelective(role) <= 0) throw new Exception("删除失败");

        return responseSuccess();

    }

    @Override
    @Transactional
    public ResultModel editRole(EditRoleVo editRoleVo) throws Exception {
        User user = userMapper.selectByPrimaryKey(TokenUtil.getUserId());
        if (ObjectUtil.isNull(user)) throw new Exception("找不到用户");

        Role role = new Role();
        ObjectUtil.annotationToObject(editRoleVo, role);

        if (roleMapper.updateByPrimaryKeySelective(role) <= 0) throw new Exception("编辑失败");
        return responseSuccess();
    }


}
