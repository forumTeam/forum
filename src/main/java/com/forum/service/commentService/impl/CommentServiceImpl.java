package com.forum.service.commentService.impl;

import com.forum.common.model.ResultModel;
import com.forum.common.utils.ObjectUtil;
import com.forum.common.utils.TokenUtil;
import com.forum.pojo.commentControllerVo.SelectCommentVo;
import com.forum.pojo.dto.SelectCommentDto;
import com.forum.pojo.myPostsControllerVo.AddCommentVo;
import com.forum.repository.domain.Comment;
import com.forum.repository.domain.User;
import com.forum.repository.mapper.CommentMapper;
import com.forum.repository.mapper.UserMapper;
import com.forum.service.commentService.CommentService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    @Transactional
    public ResultModel addComment(AddCommentVo addPostsDetailVo) throws Exception {
        Comment comment = new Comment();
        ObjectUtil.annotationToObject(addPostsDetailVo, comment);
        comment.setFkPostsId(addPostsDetailVo.getPkPostsId());
        comment.setFkUserId(TokenUtil.getUserId());

        User user = userMapper.selectByPrimaryKey(TokenUtil.getUserId());
        if (ObjectUtil.isNull(user)) throw new Exception("找不到用户");

        if (commentMapper.insertSelective(comment) <= 0) throw new Exception("添加失败");
        return responseSuccess();

    }


    @Override
    @Transactional
    public ResultModel selectComment(@RequestBody SelectCommentVo selectCommentVo) throws Exception {
        Comment comment = new Comment();
        comment.setFkPostsId(selectCommentVo.getPkPostsId());
        comment.setIsDel(false);


        PageList<Comment> comments = commentMapper.selectObjectListByWhere(comment, ofPageBounds(selectCommentVo));

        LinkedList<SelectCommentDto > selectCommentDtos=new LinkedList<>();

        for (Comment commen : comments) {
            SelectCommentDto selectCommentDto=new SelectCommentDto();
            ObjectUtil.annotationToObject(commen,selectCommentDto);
            User user = userMapper.selectByPrimaryKey(commen.getFkUserId());
            if (!ObjectUtil.isNull(user)) selectCommentDto.setNickName(user.getNickName());
            selectCommentDtos.add(selectCommentDto);
        }

        return responseSuccess(selectCommentDtos,comments.getPaginator());

    }
}
