package com.forum.service.roleService;

import com.forum.common.model.ResultModel;
import com.forum.pojo.roleControllerVo.*;
import com.forum.repository.domain.Role;
import com.forum.service.BaseService;


public interface RoleService extends BaseService {

    /**
     * 查询角色信息
     *
     * @param selectRoleVo
     * @return
     * @throws Exception
     */
    ResultModel getRoles(SelectRoleVo selectRoleVo) throws Exception;

    /**
     * 查询角色信息
     *
     * @param addRoleVo
     * @return
     * @throws Exception
     */
    ResultModel addRole(AddRoleVo addRoleVo) throws Exception;

    /**
     * 查询角色信息
     *
     * @param delRoleVo
     * @return
     * @throws Exception
     */
    ResultModel delRole(DelRoleVo delRoleVo) throws Exception;

    /**
     * 查询角色信息
     *
     * @param getRoleInfoVo
     * @return
     * @throws Exception
     */
    ResultModel getRoleInfo(GetRoleInfoVo getRoleInfoVo) throws Exception;

    /**
     * 查询角色信息
     *
     * @param editRoleVo
     * @return
     * @throws Exception
     */
    ResultModel editRole(EditRoleVo editRoleVo) throws Exception;
//    ResultModel getUserDetail()throws Exception ;
//
//    ResultModel count()throws Exception;
}
