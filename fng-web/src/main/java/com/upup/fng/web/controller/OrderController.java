package com.upup.fng.web.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.upup.fng.engine.model.dto.Result;
import com.upup.fng.service.user.OrderService;
import com.upup.fng.user.po.Stock;
import com.upup.fng.user.vo.StockVo;
import com.upup.fng.web.common.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/1/27 上午11:16
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<Stock, StockVo, OrderService> {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/createWrongOrder/{sid}")
    public Result createWrongOrder(@PathVariable int sid) {
        LOGGER.info("购买物品编号sid=[{}]", sid);
        int id = 0;
        try {
            id = this.service().createWrongOrder(sid);
            LOGGER.info("创建订单id: [{}]", id);
        } catch (Exception e) {
            LOGGER.error("Exception", e);
        }
        this.json().setMsg(String.valueOf(id));
        return this.json();
    }

    //每秒放行10个请求
    RateLimiter rateLimiter = RateLimiter.create(10);
    
    @RequestMapping("/createOptimisticOrder/{sid}")
    public Result createOptimisticOrder(@PathVariable int sid) {

        // 阻塞式获取令牌
        LOGGER.info("等待时间" + rateLimiter.acquire());
        // 非阻塞式获取令牌
        /*if (!rateLimiter.tryAcquire(100, TimeUnit.MILLISECONDS)) {
            LOGGER.warn("你被限流了，真不幸，直接返回失败");
            this.json().setMsg("购买失败，库存不足");
            return json();
        }*/
        
        LOGGER.info("购买物品编号sid=[{}]", sid);
        int id = 0;
        try {
            id = this.service().createOptimisticOrder(sid);
            LOGGER.info("购买成功，剩余库存为: [{}]", id);
            this.json().setMsg("购买成功");
        } catch (Exception e) {
            LOGGER.error("购买失败：[{}]", e.getMessage());
            this.json().setMsg("购买失败");
        }
        
        return this.json();
    }

}
