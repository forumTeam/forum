/*
* 文 件 名:  UserReviseApplyMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:UserReviseApplyMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.UserReviseApply;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserReviseApplyMapper {
    int insert(UserReviseApply record);

    int batchInsert(@Param("records") List<UserReviseApply> records);

    int insertSelective(UserReviseApply record);

    PageList<UserReviseApply> selectObjectListByWhere(UserReviseApply record, PageBounds pageBounds);

    PageList<UserReviseApply> selectByBillId(@Param("selective") UserReviseApply selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(UserReviseApply record);
}