/*
* 文 件 名:  MsnTemplateMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:MsnTemplateMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.MsnTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsnTemplateMapper {
    int deleteByPrimaryKey(Long pkMsnTemplateId);

    int insert(MsnTemplate record);

    int batchInsert(@Param("records") List<MsnTemplate> records);

    int insertSelective(MsnTemplate record);

    MsnTemplate selectByPrimaryKey(Long pkMsnTemplateId);

    PageList<MsnTemplate> selectObjectListByWhere(MsnTemplate record, PageBounds pageBounds);

    PageList<MsnTemplate> selectByBillId(@Param("selective") MsnTemplate selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(MsnTemplate record);

    int updateByPrimaryKeySelective(MsnTemplate record);

    int updateByPrimaryKey(MsnTemplate record);
}