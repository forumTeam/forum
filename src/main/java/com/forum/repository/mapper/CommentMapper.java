/*
* 文 件 名:  CommentMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:CommentMapper
* 修 改 人:  teng
* 修改时间:  2019年02月21日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Comment;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Long pkCommentId);

    int insert(Comment record);

    int batchInsert(@Param("records") List<Comment> records);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long pkCommentId);

    PageList<Comment> selectObjectListByWhere(Comment record, PageBounds pageBounds);

    PageList<Comment> selectByBillId(@Param("selective") Comment selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Comment record);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}