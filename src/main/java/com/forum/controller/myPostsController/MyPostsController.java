package com.forum.controller.myPostsController;

import com.forum.common.model.ResultModel;
import com.forum.pojo.myPostsControllerVo.AddPostsVo;
import com.forum.pojo.myPostsControllerVo.SelectPostsDetailVo;
import com.forum.pojo.myPostsControllerVo.SelectPostsVo;
import com.forum.service.myPostsService.MyPostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "帖子")
@RestController
@RequestMapping("myPosts")
public class MyPostsController {


    @Autowired
    private MyPostsService myPostsService;

    @ApiOperation(value = "添加帖子" , notes = "靳旺")
    @RequestMapping(value = "addPosts" , method = RequestMethod.POST)
    public ResultModel addPosts(@RequestBody AddPostsVo addPostsVo)throws Exception{
        return  myPostsService.addPosts(addPostsVo);
    }


    @ApiOperation(value = "查询帖子" , notes = "靳旺")
    @RequestMapping(value = "selectPosts" , method = RequestMethod.POST)
    public ResultModel selectPosts(@RequestBody SelectPostsVo selectPostsVo)throws Exception{
        return  myPostsService.selectPosts(selectPostsVo);
    }


    @ApiOperation(value = "查询帖子" , notes = "靳旺")
    @RequestMapping(value = "selectPostsDetail" , method = RequestMethod.POST)
    public ResultModel selectPostsDetail(@RequestBody SelectPostsDetailVo selectPostsDetailVo)throws Exception{
        return  myPostsService.selectPostsDetail(selectPostsDetailVo);
    }




}
