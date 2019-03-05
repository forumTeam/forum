package com.forum.pojo.dto;

import com.forum.repository.domain.Dynamic;
import lombok.Data;

@Data
public class SelectDynamicDto extends Dynamic {


    /**
     * 昵称
     */
    private String nickName;


}
