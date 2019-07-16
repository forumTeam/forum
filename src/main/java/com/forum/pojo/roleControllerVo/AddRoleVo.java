package com.forum.pojo.roleControllerVo;

import com.forum.common.validator.annotation.Enums;
import com.forum.common.validator.annotation.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class AddRoleVo {

    /**
     * 姓名
     */
    @NotEmpty
    @ApiModelProperty(value = "姓名",required = true)
    private String name;

    /**
     * 描述
     */
    @NotEmpty
    @ApiModelProperty(value = "描述",required = true)
    private String description;

//    /**
//     * 权限
//     */
//    @ApiModelProperty(value = "权限",required = true)
//    private String permissionIds;
}
