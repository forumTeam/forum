package com.forum.service;

import com.forum.common.model.PageResultModel;
import com.forum.common.model.ResultModel;
import com.forum.common.utils.PageBoundsUtil;
import com.forum.pojo.AbstractVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface BaseService {


    Logger logger = LoggerFactory.getLogger(BaseService.class);

    /**
     * 获取分页对象
     *
     * @param abstractVo
     * @return
     */
    default PageBounds ofPageBounds(AbstractVo abstractVo) {
        return PageBoundsUtil.of(abstractVo.getPageIndex(), abstractVo.getPageSize(), abstractVo.getOrder());
    }

    /**
     * 获取默认分页
     *
     * @return
     */
    default PageBounds ofPageBounds() {
        return PageBoundsUtil.of();
    }

    /**
     * 返回成功请求
     *
     * @return
     */
    default ResultModel responseSuccess() {
        return ResultModel.getSuccessResultModel();
    }

    /**
     * 返回请求成功
     *
     * @param data
     * @param <T>
     * @return
     */
    default <T> ResultModel responseSuccess(T data) {
        return ResultModel.getSuccessResultModel(data);
    }

    /**
     * 返回带分页数据
     *
     * @param data
     * @param paginator
     * @param <T>
     * @return
     */
    default <T> PageResultModel responseSuccess(T data, Paginator paginator) {
        return PageResultModel.getSuccessResultModel(data, paginator);
    }

    /**
     * 请求失败
     *
     * @param message
     * @param objects
     * @throws Exception
     */
    default void responseError(String message, Object... objects) throws Exception {
        throw new Exception(String.format(message, objects));
    }

}
