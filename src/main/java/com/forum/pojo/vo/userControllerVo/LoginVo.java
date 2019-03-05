package com.forum.pojo.vo.userControllerVo;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class LoginVo {


    /**
     * 用户名
     */
    @NotEmpty
    @ApiModelProperty(value = "用户名")
    public String account;

    /**
     * 密码
     */
    @NotEmpty
    @ApiModelProperty(value = "密码")
    public String password;


}
