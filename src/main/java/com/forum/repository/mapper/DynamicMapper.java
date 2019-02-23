/*
* 文 件 名:  DynamicMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:DynamicMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Dynamic;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicMapper {
    int deleteByPrimaryKey(Long pkDynamicId);

    int insert(Dynamic record);

    int batchInsert(@Param("records") List<Dynamic> records);

    int insertSelective(Dynamic record);

    Dynamic selectByPrimaryKey(Long pkDynamicId);

    PageList<Dynamic> selectObjectListByWhere(Dynamic record, PageBounds pageBounds);

    PageList<Dynamic> selectByBillId(@Param("selective") Dynamic selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Dynamic record);

    int updateByPrimaryKeySelective(Dynamic record);

    int updateByPrimaryKeyWithBLOBs(Dynamic record);

    int updateByPrimaryKey(Dynamic record);
}