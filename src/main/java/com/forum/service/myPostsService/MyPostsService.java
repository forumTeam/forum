package com.forum.service.myPostsService;

import com.forum.common.model.ResultModel;
import com.forum.pojo.myPostsControllerVo.AddPostsVo;
import com.forum.pojo.myPostsControllerVo.SelectPostsDetailVo;
import com.forum.pojo.myPostsControllerVo.SelectPostsVo;
import com.forum.service.BaseService;


public interface MyPostsService extends BaseService {

    ResultModel addPosts(AddPostsVo addPostsVo) throws Exception;

    ResultModel selectPosts(SelectPostsVo selectPostsVo) throws Exception;


    ResultModel selectPostsDetail(SelectPostsDetailVo selectPostsDetailVo) throws Exception;

}
