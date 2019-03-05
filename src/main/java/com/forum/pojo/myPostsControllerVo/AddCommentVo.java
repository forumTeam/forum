package com.forum.pojo.myPostsControllerVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
@Data
public class AddCommentVo {

    /**
     * 帖子id
     */
    @NotEmpty
    @ApiModelProperty(value = "帖子id",required = true)
    private Long pkPostsId;

    /**
     * 评论内容
     */
    @NotEmpty
    @Size(max = 10*1024)
    @ApiModelProperty(value = "评论内容",required = true)
    private String content;

}




