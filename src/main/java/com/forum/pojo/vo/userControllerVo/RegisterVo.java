package com.forum.pojo.vo.userControllerVo;

import com.forum.common.validator.annotation.Enums;
import com.forum.common.validator.annotation.Phone;
import io.swagger.annotations.ApiModelProperty;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class RegisterVo {

    /**
     * 账号
     */
    @NotEmpty
    @ApiModelProperty(value = "账号",required = true)
    private String account;


    /**
     * 姓名
     */
    @NotEmpty
    @ApiModelProperty(value = "姓名",required = true)
    private String name;

    /**
     * 登陆密码
     */
    @NotEmpty
    @ApiModelProperty(value = "登陆密码",required = true)
    private String password;



    /**
     * 性别 0：男，1：女
     */
    @Enums(value = {"男", "女"}, message = "sex in {男, 女}")
    @ApiModelProperty(value = "性别",required = true)
    private String sex;


    /**
     * 昵称
     */
    @NotEmpty
    @ApiModelProperty(value = "昵称",required = true)
    private String nickName;


    /**
     * qq账号
     */
    @NotEmpty
    @ApiModelProperty(value = "qq账号",required = true)
    private String qq;

    /**
     * 手机号
     */
    @Phone
    @NotEmpty
    @ApiModelProperty(value = "手机号",required = true)
    private String phone;


}
