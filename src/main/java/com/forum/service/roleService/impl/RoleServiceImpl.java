package com.forum.service.roleService.impl;

import com.forum.common.model.ResultModel;
import com.forum.common.model.Token;
import com.forum.common.utils.*;
import com.forum.pojo.dto.CountDto;
import com.forum.repository.domain.Role;
import com.forum.repository.domain.User;
import com.forum.repository.mapper.UserMapper;
import com.forum.pojo.roleControllerVo.AddRoleVo;
import com.forum.pojo.roleControllerVo.DelRoleVo;
import com.forum.pojo.roleControllerVo.SelectRoleVo;
import com.forum.pojo.roleControllerVo.EditRoleVo;
import com.forum.repository.mapper.RoleMapper;
import com.forum.repository.mapper.ext.DynamicMapperExt;
import com.forum.repository.mapper.ext.PostsMapperExt;
import com.forum.service.roleService.RoleService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DynamicMapperExt dynamicMapperExt;

    @Autowired
    private PostsMapperExt postsMapperExt;






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
    public ResultModel  getRoleInfo(Long id) throws Exception {
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role==null){
            throw new Exception("未查到该角色");
        }
//        if (ObjectUtil.isNull(role)) throw new Exception("未查到该角色");
        return responseSuccess(role);
    }

    @Override
    @Transactional
    public ResultModel addRole(AddRoleVo addRoleVo) throws Exception {
        Role role = new Role();
        ObjectUtil.annotationToObject(addRoleVo, role);
//        role.setFkUserId(TokenUtil.getUserId());


        User user = userMapper.selectByPrimaryKey(TokenUtil.getUserId());
        if (ObjectUtil.isNull(user)) throw new Exception("找不到用户");


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
    public ResultModel   editRole(EditRoleVo editRoleVo) throws Exception {
        Role role = new Role();
        role.setPkRoleId(editRoleVo.getPkRoleId());
        role.setName(editRoleVo.getName());
        role.setDescription(editRoleVo.getDescription());
//        ObjectUtil.annotationToObject(editRoleVo, role);

//        User user = userMapper.selectByPrimaryKey(TokenUtil.getUserId());
//        if (ObjectUtil.isNull(user)) throw new Exception("找不到用户");
//
//
        if (roleMapper.updateByPrimaryKeySelective(role) <= 0) throw new Exception("编辑失败");
        return responseSuccess();
    }








}
