/*
* 文 件 名:  RoleMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:RoleMapper
* 修 改 人:  Administrator
* 修改时间:  2019年07月09日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.Role;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long pkRoleId);

    int insert(Role record);

    int batchInsert(@Param("records") List<Role> records);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long pkRoleId);

    PageList<Role> selectObjectListByWhere(Role record, PageBounds pageBounds);

    PageList<Role> selectByBillId(@Param("selective") Role selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(Role record);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}