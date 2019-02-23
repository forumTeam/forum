package com.forum.pojo.dto;

import com.forum.repository.domain.Comment;
import lombok.Data;

@Data
public class SelectCommentDto extends Comment {


    /**
     * 昵称
     */
    private String nickName;


}
