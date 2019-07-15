package com.forum.pojo.roleControllerVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class GetRoleInfoVo {

    /**
     * 角色id
     */
    @NonNull
    @ApiModelProperty(value = "角色id", required = true)
    private Long pkRoleId;


}
