package com.forum.pojo.commentControllerVo;

import com.forum.pojo.AbstractVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class SelectCommentVo extends AbstractVo {


    /**
     * 主键
     */
    @NotEmpty
    @ApiModelProperty(value = "主键" , required = true)
    private Long pkPostsId;


}
