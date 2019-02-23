package com.forum.common.model;

import com.forum.common.constant.ErrorCodeEnum;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import lombok.Data;


/**
 * 带有分页数据的结果对象
 */
@Data
public class PageResultModel<T> extends ResultModel<T> {

    private Paginator paginator;

    private PageResultModel(T data, ErrorCodeEnum code) {
        super(data, code);
    }

    private PageResultModel(int code, String message, T data) {
        super(code, message, data);
    }

    private PageResultModel(T data, Paginator paginator) {
        super(data);
        this.paginator = paginator;
    }

    private PageResultModel(T data, Paginator paginator, ErrorCodeEnum code) {
        super(data, code);
        this.paginator = paginator;
    }

    public static <T> PageResultModel<T> getSuccessResultModel(T data, Paginator paginator) {
        return new PageResultModel<>(data, paginator);
    }

    public static <T> PageResultModel<T> getSuccessResultModel(T data, Paginator paginator, ErrorCodeEnum code) {
        return new PageResultModel<>(data, paginator, code);
    }
}
