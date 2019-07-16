package com.forum.controller.roleController;


import com.forum.common.model.ResultModel;
import com.forum.pojo.roleControllerVo.*;
import com.forum.service.roleService.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "角色")
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @ApiOperation(value = "查询角色信息", notes = "靳旺")
    @RequestMapping(value = "getRoles", method = RequestMethod.POST)
    public ResultModel getRoles(@RequestBody SelectRoleVo selectRoleVo) throws Exception {
        return roleService.getRoles(selectRoleVo);
    }

    @ApiOperation(value = "查询角色详情", notes = "靳旺")
    @RequestMapping(value = "getRoleInfo", method = RequestMethod.POST)
    public ResultModel getRoleInfo(@RequestBody @Valid GetRoleInfoVo getRoleInfoVo) throws Exception {
        return roleService.getRoleInfo(getRoleInfoVo);
    }

    @ApiOperation(value = "添加角色", notes = "sbd")
    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    public ResultModel addRole(@RequestBody @Valid AddRoleVo addRoleVo) throws Exception {
        return roleService.addRole(addRoleVo);
    }

    @ApiOperation(value = "删除角色", notes = "sbd")
    @RequestMapping(value = "delRole", method = RequestMethod.POST)
    public ResultModel delRole(@RequestBody @Valid DelRoleVo delRoleVo) throws Exception {
        return roleService.delRole(delRoleVo);
    }

    @ApiOperation(value = "编辑角色", notes = "sbd")
    @RequestMapping(value = "editRole", method = RequestMethod.POST)
    public ResultModel editRole(@RequestBody @Valid EditRoleVo editRoleVo) throws Exception {
        return roleService.editRole(editRoleVo);
    }


}
