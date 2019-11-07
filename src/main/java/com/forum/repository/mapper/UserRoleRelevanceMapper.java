/*
* 文 件 名:  UserRoleRelevanceMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:UserRoleRelevanceMapper
* 修 改 人:  teng
* 修改时间:  2019年11月07日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.UserRoleRelevance;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelevanceMapper {
    int deleteByPrimaryKey(Long pkUserRoleRelevanceId);

    int insert(UserRoleRelevance record);

    int batchInsert(@Param("records") List<UserRoleRelevance> records);

    int insertSelective(UserRoleRelevance record);

    UserRoleRelevance selectByPrimaryKey(Long pkUserRoleRelevanceId);

    PageList<UserRoleRelevance> selectObjectListByWhere(UserRoleRelevance record, PageBounds pageBounds);

    PageList<UserRoleRelevance> selectByBillId(@Param("selective") UserRoleRelevance selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(UserRoleRelevance record);

    int updateByPrimaryKeySelective(UserRoleRelevance record);

    int updateByPrimaryKey(UserRoleRelevance record);
}