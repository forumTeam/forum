package com.forum.service.commentService;

import com.forum.common.model.ResultModel;

import com.forum.pojo.commentControllerVo.SelectCommentVo;
import com.forum.pojo.myPostsControllerVo.AddCommentVo;
import com.forum.service.BaseService;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommentService extends BaseService {

    ResultModel addComment(AddCommentVo addPostsDetailVo)throws Exception;

    ResultModel selectComment(@RequestBody SelectCommentVo selectCommentVo)throws Exception;
}
