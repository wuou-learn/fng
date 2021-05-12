package com.upup.fng.user.po;

import com.upup.fng.common.BaseEntity;
import lombok.Data;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/1/27 上午11:23
 */
@Data
public class Stock extends BaseEntity {
    private int id;

    /**
     * 名称
     */
    private String name;

    /**
     * 库存
     */
    private int count;

    /**
     * 已售
     */
    private int sale;

    /**
     * 版本号
     */
    private int version;
}
