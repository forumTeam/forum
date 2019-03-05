package com.forum.pojo.dto;

import com.forum.repository.domain.Posts;
import lombok.Data;

@Data
public class SelectPostsDto extends Posts {

    /**
     * 昵称
     */
    private String nickName;



}
