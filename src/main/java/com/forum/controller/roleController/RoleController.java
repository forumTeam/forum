package com.forum.controller.roleController;


import com.alibaba.fastjson.JSON;
import com.forum.common.listener.rabbitmq.util.QueueEnum;
import com.forum.common.listener.rabbitmq.util.TeskExchangeUtil;
import com.forum.common.model.ResultModel;
import com.forum.common.shiro.ShrioRealm;
import com.forum.repository.domain.Role;
import com.forum.pojo.roleControllerVo.AddRoleVo;
import com.forum.pojo.roleControllerVo.EditRoleVo;
import com.forum.pojo.roleControllerVo.DelRoleVo;
import com.forum.pojo.roleControllerVo.SelectRoleVo;
import com.forum.service.roleService.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.ArrayList;

@Api(tags = "角色")
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ShrioRealm shrioRealm;

    @Autowired
    private TeskExchangeUtil teskExchangeUtil;



    @ApiOperation(value = "查询角色信息", notes = "靳旺")
    @RequestMapping(value = "getRoles", method = RequestMethod.POST)
    public ResultModel getRoles(@RequestBody SelectRoleVo selectRoleVo) throws Exception {
        return roleService.getRoles(selectRoleVo);
    }

    @ApiOperation(value = "查询角色详情", notes = "靳旺")
    @RequestMapping(value = "getRoleInfo/{id}", method = RequestMethod.GET)
    public ResultModel getRoleInfo(@PathVariable Long id) throws Exception {
        return roleService.getRoleInfo(id);
    }


    @ApiOperation(value = "添加角色" , notes = "sbd")
    @RequestMapping(value = "addRole" , method = RequestMethod.POST)
    public ResultModel addRole(@RequestBody AddRoleVo addRoleVo)throws Exception{
        return  roleService.addRole(addRoleVo);
    }

    @ApiOperation(value = "删除角色", notes = "sbd")
    @RequestMapping(value = "delRole", method = RequestMethod.POST)
    public ResultModel delRole(@RequestBody DelRoleVo delRoleVo) throws Exception {

        return roleService.delRole(delRoleVo);
    }

    @ApiOperation(value = "编辑角色", notes = "sbd")
    @RequestMapping(value = "editRole", method = RequestMethod.POST)
    public ResultModel editRole(@RequestBody EditRoleVo editRoleVo) throws Exception {

        return roleService.editRole(editRoleVo);
    }


}
