package com.forum.service.dynamicService.impl;

import com.forum.common.model.ResultModel;
import com.forum.common.utils.ObjectUtil;
import com.forum.common.utils.TokenUtil;
import com.forum.pojo.dto.SelectDynamicDto;
import com.forum.pojo.dynamicControllerVo.AddDynamicVo;
import com.forum.pojo.dynamicControllerVo.DelDynamicVo;
import com.forum.pojo.dynamicControllerVo.SelectDynamicDetailVo;
import com.forum.pojo.dynamicControllerVo.SelectDynamicVo;
import com.forum.repository.domain.Dynamic;
import com.forum.repository.domain.User;
import com.forum.repository.mapper.DynamicMapper;
import com.forum.repository.mapper.UserMapper;
import com.forum.repository.mapper.ext.DynamicMapperExt;
import com.forum.service.dynamicService.DynamicService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicMapperExt dynamicMapperExt;

    @Autowired
    private DynamicMapper dynamicMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public ResultModel addDynamic(AddDynamicVo addDynamicVo) throws Exception {

        Dynamic dynamic = new Dynamic();

        ObjectUtil.annotationToObject(addDynamicVo, dynamic);

        dynamic.setIsDel(false);
        dynamic.setFkUserId(TokenUtil.getUserId());

        User user=userMapper.selectByPrimaryKey(TokenUtil.getUserId());
        user.setDynamicTotal(user.getTotalTotal()+1);
        if (userMapper.updateByPrimaryKeySelective(user) <= 0 ) throw new Exception("动态发送失败");

        if (dynamicMapper.insertSelective(dynamic) <= 0) throw new Exception("动态发送失败");
        return responseSuccess();
    }


    @Override
    public ResultModel delDynamic(DelDynamicVo delDynamicVo) throws Exception {

        if (delDynamicVo.getPkDynamicId() == null) throw new Exception("帖子id不能为空");

        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(delDynamicVo.getPkDynamicId());
        if (ObjectUtil.isNull(dynamic)) throw new Exception("查无此动态");

        dynamic.setIsDel(true);

        if (dynamicMapper.updateByPrimaryKeySelective(dynamic) <= 0) throw new Exception("删除失败");
        return responseSuccess();

    }


    @Override
    public ResultModel selectDynamic(SelectDynamicVo selectDynamicVo) {
        Dynamic dynamic = new Dynamic();

        ObjectUtil.annotationToObject(selectDynamicVo, dynamic);
        dynamic.setIsDel(false);

        PageList<Dynamic> dynamics = dynamicMapperExt.selectObjectListByWhere(dynamic, ofPageBounds(selectDynamicVo));

        LinkedList<SelectDynamicDto> selectDynamicDtos=new LinkedList<>();
        for (Dynamic dynami:dynamics) {
            SelectDynamicDto selectDynamicDto=new SelectDynamicDto();
            ObjectUtil.annotationToObject(dynami,selectDynamicDto);

            User user = userMapper.selectByPrimaryKey(dynami.getFkUserId());
            selectDynamicDto.setNickName(user.getNickName());
            selectDynamicDtos.add(selectDynamicDto);
        }


        return responseSuccess(selectDynamicDtos, dynamics.getPaginator());
    }


    @Override
    public ResultModel selectDynamicDetail(SelectDynamicDetailVo selectDynamicDetailVo) throws Exception {

        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(selectDynamicDetailVo.getPkDynamicId());

        if (ObjectUtil.isNull(dynamic)) throw new Exception("查无此动态");

        return responseSuccess(dynamic);
    }
}
