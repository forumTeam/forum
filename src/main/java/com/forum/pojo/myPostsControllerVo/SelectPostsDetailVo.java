package com.forum.pojo.myPostsControllerVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SelectPostsDetailVo {


    /**
     * 主键
     */
    @NotNull
    @ApiModelProperty(value = "主键" , required = true)
    private Long pkPostsId;
}
