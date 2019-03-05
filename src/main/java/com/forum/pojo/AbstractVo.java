package com.forum.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AbstractVo implements BaseVo {

    /**
     * 页码
     */
    @ApiModelProperty("页码")
    private int pageIndex;

    /**
     * 每页数量
     */
    @ApiModelProperty("每页数量")
    private int pageSize;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private String order;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 开始 创建时间
     */
    @ApiModelProperty("开始 创建时间")
    private Date startCreateTime;

    /**
     * 结束 创建时间
     */
    @ApiModelProperty("结束 创建时间")
    private Date endCreateTime;
}
