/*
* 文 件 名:  InformationMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:InformationMapper
* 修 改 人:  teng
* 修改时间:  2019年07月04日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Information;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Long pkMessageId);

    int insert(Information record);

    int batchInsert(@Param("records") List<Information> records);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Long pkMessageId);

    PageList<Information> selectObjectListByWhere(Information record, PageBounds pageBounds);

    PageList<Information> selectByBillId(@Param("selective") Information selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Information record);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}