package com.forum.pojo.dto;

import lombok.Data;

import java.util.Date;


@Data
public class CountDto {

    public Date createPostsTime;

    public Integer PostsCount;


    public Date createDynamicTime;

    public Integer  DynamicCount;


}
