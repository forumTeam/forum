package com.forum.pojo.myPostsControllerVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class AddPostsVo {

    /**
     * 帖子标题
     */
    @NotEmpty
    @Size(max = 128,min = 1)
    @ApiModelProperty(value = "帖子标题",required = true)
    private String postsTitle;


    /**
     * 帖子内容
     */
    @NotEmpty
    @Size(max = 10*1024)
    @ApiModelProperty(value = "帖子内容",required = true)
    private String postsContent;
}
