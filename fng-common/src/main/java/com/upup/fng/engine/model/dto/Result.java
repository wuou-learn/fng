package com.upup.fng.engine.model.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author wuou
 * @version 1.0.0
 * @date [2020/7/31 下午2:48]
 */
@Data
public class Result {
    /** 是否异常 */
    private boolean exception;

    /** 是否成功 */
    protected boolean success;

    /** 描述信息 */
    protected String msg;

    /** 返回对象 */
    private Object bean;

    /** 分页查询结果 */
    private Page<?> page;

    /** 返回集合 */
    private List<?> list;

    /** 返回集合map */
    private Map<?,?> map;

    /**
     * 默认返回结果
     */
    public Result(){
        this.exception = false;
        this.success = true;
        this.msg = "";
    }
}
