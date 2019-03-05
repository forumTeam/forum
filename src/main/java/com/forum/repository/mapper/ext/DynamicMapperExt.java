/*
* 文 件 名:  DynamicMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:DynamicMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper.ext;

import com.forum.pojo.dto.CountDto;
import com.forum.repository.domain.Dynamic;
import com.forum.repository.domain.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicMapperExt {

    List<CountDto> count(@Param("selective") User user);


    PageList<Dynamic> selectObjectListByWhere(@Param("selective") Dynamic record, PageBounds pageBounds);
}