package com.upup.fng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.upup.fng.user.po.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * *****************************************
 * @author wuou [2020/7/30 上午11:45]
 * @version 5.0.0
 * *****************************************
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    int updateByOptimistic(Stock record);
    
}
