package com.forum.service.roleService;

import com.forum.common.model.ResultModel;
import com.forum.repository.domain.Role;
import com.forum.pojo.roleControllerVo.AddRoleVo;
import com.forum.pojo.roleControllerVo.DelRoleVo;
import com.forum.pojo.roleControllerVo.EditRoleVo;
import com.forum.pojo.roleControllerVo.SelectRoleVo;
import com.forum.service.BaseService;


public interface RoleService extends BaseService {

    ResultModel getRoles(SelectRoleVo selectRoleVo) throws Exception;
    ResultModel addRole(AddRoleVo addRoleVo) throws Exception;
    ResultModel delRole(DelRoleVo delRoleVo) throws Exception;
    ResultModel getRoleInfo(Long id) throws Exception;
    ResultModel editRole(EditRoleVo editRoleVo) throws Exception;
//    ResultModel getUserDetail()throws Exception ;
//
//    ResultModel count()throws Exception;
}
