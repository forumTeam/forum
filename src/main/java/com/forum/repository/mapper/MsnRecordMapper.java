/*
* 文 件 名:  MsnRecordMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:MsnRecordMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.MsnRecord;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsnRecordMapper {
    int deleteByPrimaryKey(Long pkMsnRecordId);

    int insert(MsnRecord record);

    int batchInsert(@Param("records") List<MsnRecord> records);

    int insertSelective(MsnRecord record);

    MsnRecord selectByPrimaryKey(Long pkMsnRecordId);

    PageList<MsnRecord> selectObjectListByWhere(MsnRecord record, PageBounds pageBounds);

    PageList<MsnRecord> selectByBillId(@Param("selective") MsnRecord selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(MsnRecord record);

    int updateByPrimaryKeySelective(MsnRecord record);

    int updateByPrimaryKey(MsnRecord record);
}