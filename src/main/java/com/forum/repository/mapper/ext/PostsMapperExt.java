/*
* 文 件 名:  PostsMapper.java
* 版     权:  百立特信息技术有限公司
* 描     述:  数据库实体类:PostsMapper
* 修 改 人:  teng
* 修改时间:  2019年01月29日
* 修改内容:  <修改内容>
*/
package com.forum.repository.mapper.ext;


import com.forum.pojo.dto.CountDto;
import com.forum.repository.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostsMapperExt {


    List<CountDto> count(@Param("selective") User user);

}