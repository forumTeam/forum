/*
* 文 件 名:  PostsMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:PostsMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Posts;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostsMapper {
    int deleteByPrimaryKey(Long pkPostsId);

    int insert(Posts record);

    int batchInsert(@Param("records") List<Posts> records);

    int insertSelective(Posts record);

    Posts selectByPrimaryKey(Long pkPostsId);

    PageList<Posts> selectObjectListByWhere(Posts record, PageBounds pageBounds);

    PageList<Posts> selectByBillId(@Param("selective") Posts selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Posts record);

    int updateByPrimaryKeySelective(Posts record);

    int updateByPrimaryKeyWithBLOBs(Posts record);

    int updateByPrimaryKey(Posts record);
}