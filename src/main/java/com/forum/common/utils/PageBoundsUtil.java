package com.forum.common.utils;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;

public class PageBoundsUtil {

    /** 默认的分页对象 */
    private static final PageBounds DEFAULT_PAGE_BOUNDS = new PageBounds();


    /** 倒序排序 */
    private static final String DESC = "desc";

    /** 正序排序 */
    private static final String ASC = "asc";


    /** 倒序排序Order */
    private static final List<Order> ORDER_DESC = Order.formString("create_time.desc");

    /** 正序排序Order */
    private static final List<Order> ORDER_ASC = Order.formString("create_time.desc");


    /**
     * 返回默认分页
     * @return
     */
    public static PageBounds of() {
        return DEFAULT_PAGE_BOUNDS;
    }

    /**
     * 返回分页对象
     * @param pageIndex
     * @param pageSize
     * @param order
     * @return
     */
    public static PageBounds of(int pageIndex,int pageSize,String order){
        if (!StringUtil.isEmpty(order) && order.equals(ASC)) new PageBounds(pageIndex,pageSize,ORDER_ASC,true);
        return new PageBounds(pageIndex,pageSize,ORDER_DESC,true);
    }
}
