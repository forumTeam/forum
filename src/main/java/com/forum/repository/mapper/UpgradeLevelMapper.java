/*
* 文 件 名:  UpgradeLevelMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:UpgradeLevelMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.UpgradeLevel;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpgradeLevelMapper {
    int deleteByPrimaryKey(Long pkUpgradeLevelId);

    int insert(UpgradeLevel record);

    int batchInsert(@Param("records") List<UpgradeLevel> records);

    int insertSelective(UpgradeLevel record);

    UpgradeLevel selectByPrimaryKey(Long pkUpgradeLevelId);

    PageList<UpgradeLevel> selectObjectListByWhere(UpgradeLevel record, PageBounds pageBounds);

    PageList<UpgradeLevel> selectByBillId(@Param("selective") UpgradeLevel selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(UpgradeLevel record);

    int updateByPrimaryKeySelective(UpgradeLevel record);

    int updateByPrimaryKey(UpgradeLevel record);
}