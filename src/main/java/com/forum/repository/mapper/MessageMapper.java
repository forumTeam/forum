/*
* 文 件 名:  MessageMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:MessageMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Message;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Long pkMessageId);

    int insert(Message record);

    int batchInsert(@Param("records") List<Message> records);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long pkMessageId);

    PageList<Message> selectObjectListByWhere(Message record, PageBounds pageBounds);

    PageList<Message> selectByBillId(@Param("selective") Message selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Message record);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}