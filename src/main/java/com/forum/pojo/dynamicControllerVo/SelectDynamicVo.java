package com.forum.pojo.dynamicControllerVo;

import com.forum.pojo.AbstractVo;
import com.forum.pojo.BaseVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectDynamicVo  extends AbstractVo {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long pkDynamicId;


    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String dynamicTitle;


}
