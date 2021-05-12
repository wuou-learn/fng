package com.upup.fng.user.po;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @author wuou
 * @version 1.0.0
 * @date 2021/1/27 上午11:25
 */
@Data
public class StockOrder {
    
    private int id;

    /**
     * 库存ID
     */
    private int sid;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;
}
