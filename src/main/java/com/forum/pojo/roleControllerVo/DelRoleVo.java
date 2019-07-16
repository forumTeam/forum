package com.forum.pojo.roleControllerVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class DelRoleVo {

    /**
     * 主键
     */
    @NotNull
    @ApiModelProperty(value = "主键", required = true)
    private Long pkRoleId;

}
