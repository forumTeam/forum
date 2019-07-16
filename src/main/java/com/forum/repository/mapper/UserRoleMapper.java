/*
* 文 件 名:  UserRoleMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:UserRoleMapper
* 修 改 人:  teng
* 修改时间:  2019年07月16日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.UserRole;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long pkUserId);

    int insert(UserRole record);

    int batchInsert(@Param("records") List<UserRole> records);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long pkUserId);

    PageList<UserRole> selectObjectListByWhere(UserRole record, PageBounds pageBounds);

    PageList<UserRole> selectByBillId(@Param("selective") UserRole selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(UserRole record);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}