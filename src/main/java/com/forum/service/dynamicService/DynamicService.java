package com.forum.service.dynamicService;

import com.forum.common.model.ResultModel;
import com.forum.pojo.dynamicControllerVo.AddDynamicVo;
import com.forum.pojo.dynamicControllerVo.DelDynamicVo;
import com.forum.pojo.dynamicControllerVo.SelectDynamicDetailVo;
import com.forum.pojo.dynamicControllerVo.SelectDynamicVo;
import com.forum.service.BaseService;


public interface DynamicService extends BaseService {


    ResultModel selectDynamic(SelectDynamicVo selectDynamicVo) throws Exception;


    ResultModel addDynamic(AddDynamicVo addDynamicVo) throws Exception;


    ResultModel delDynamic(DelDynamicVo delDynamicVo) throws Exception;


    ResultModel selectDynamicDetail(SelectDynamicDetailVo selectDynamicDetailVo) throws Exception;
}
