package com.forum.controller.dynamicController;


import com.forum.common.model.ResultModel;
import com.forum.pojo.dynamicControllerVo.AddDynamicVo;
import com.forum.pojo.dynamicControllerVo.DelDynamicVo;
import com.forum.pojo.dynamicControllerVo.SelectDynamicDetailVo;
import com.forum.pojo.dynamicControllerVo.SelectDynamicVo;
import com.forum.service.dynamicService.DynamicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "动态")
@RestController
@RequestMapping("dynamic")
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;

    @ApiOperation(value = "查询动态  ", notes = "靳旺")
    @RequestMapping(value = "selectDynamic", method = RequestMethod.POST)
    public ResultModel selectDynamic(@RequestBody SelectDynamicVo selectDynamicVo) throws Exception {

        return dynamicService.selectDynamic(selectDynamicVo);
    }


    @ApiOperation(value = "添加动态", notes = "靳旺")
    @RequestMapping(value = "addDynamic", method = RequestMethod.POST)
    public ResultModel addDynamic(@RequestBody AddDynamicVo addDynamicVo) throws Exception {

        return dynamicService.addDynamic(addDynamicVo);
    }


    @ApiOperation(value = "删除动态", notes = "靳旺")
    @RequestMapping(value = "delDynamic", method = RequestMethod.POST)
    public ResultModel delDynamic(@RequestBody DelDynamicVo delDynamicVo) throws Exception {

        return dynamicService.delDynamic(delDynamicVo);
    }


    @ApiOperation(value = "查询动态详情", notes = "靳旺")
    @RequestMapping(value = "selectDynamicDetail", method = RequestMethod.POST)
    public ResultModel selectDynamicDetail(@RequestBody SelectDynamicDetailVo selectDynamicDetailVo) throws Exception {

        return dynamicService.selectDynamicDetail(selectDynamicDetailVo);

    }


}
