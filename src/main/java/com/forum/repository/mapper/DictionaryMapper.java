/*
* 文 件 名:  DictionaryMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:DictionaryMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Dictionary;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Long pkDictionaryId);

    int insert(Dictionary record);

    int batchInsert(@Param("records") List<Dictionary> records);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long pkDictionaryId);

    PageList<Dictionary> selectObjectListByWhere(Dictionary record, PageBounds pageBounds);

    PageList<Dictionary> selectByBillId(@Param("selective") Dictionary selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Dictionary record);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}