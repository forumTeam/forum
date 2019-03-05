/*
* 文 件 名:  UserMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:UserMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper;

import com.forum.repository.domain.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long pkUserId);

    int insert(User record);

    int batchInsert(@Param("records") List<User> records);

    int insertSelective(User record);

    User selectByPrimaryKey(Long pkUserId);

    PageList<User> selectObjectListByWhere(User record, PageBounds pageBounds);

    PageList<User> selectByBillId(@Param("selective") User selective, @Param("ids") List<Long> ids, PageBounds pageBounds);

    int selectCountByWhere(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}