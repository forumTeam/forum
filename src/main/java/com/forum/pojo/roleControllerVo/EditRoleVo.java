package com.forum.pojo.roleControllerVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class EditRoleVo {

    /**
     * 主键
     */
    @NotNull
    @ApiModelProperty(value = "主键", required = true)
    private Long pkRoleId;

    /**
     * 姓名
     */
    @NotEmpty
    @ApiModelProperty(value = "姓名",required = true)
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述",required = true)
    private String description;

}
