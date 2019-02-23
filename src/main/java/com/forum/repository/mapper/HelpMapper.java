/*
* 文 件 名:  HelpMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:HelpMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Help;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HelpMapper {
    int deleteByPrimaryKey(Long pkHelpId);

    int insert(Help record);

    int batchInsert(@Param("records") List<Help> records);

    int insertSelective(Help record);

    Help selectByPrimaryKey(Long pkHelpId);

    PageList<Help> selectObjectListByWhere(Help record, PageBounds pageBounds);

    PageList<Help> selectByBillId(@Param("selective") Help selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Help record);

    int updateByPrimaryKeySelective(Help record);

    int updateByPrimaryKey(Help record);
}