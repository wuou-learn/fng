package com.upup.fng.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.upup.fng.user.po.Stock;

public interface OrderService extends IService<Stock> {
    
    int createWrongOrder(int sid);
    
    int createOptimisticOrder(int sid);
}
