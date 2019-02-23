package com.forum.controller.commentController;

import com.forum.common.model.ResultModel;
import com.forum.pojo.commentControllerVo.SelectCommentVo;
import com.forum.pojo.myPostsControllerVo.AddCommentVo;
import com.forum.service.commentService.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "评论")
@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @ApiOperation(value = "添加帖子评论" , notes = "刘帅")
    @RequestMapping(value = "addComment" , method = RequestMethod.POST)
    public ResultModel addComment(@RequestBody AddCommentVo addCommentVo)throws Exception{
        return  commentService.addComment(addCommentVo);
    }

    @ApiOperation(value = "添加帖子评论" , notes = "靳旺")
    @RequestMapping(value = "selectComment" , method = RequestMethod.POST)
    public ResultModel selectComment(@RequestBody SelectCommentVo selectCommentVo)throws Exception{
        return commentService.selectComment(selectCommentVo);
    }

}
