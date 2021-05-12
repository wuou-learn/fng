package com.upup.fng.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upup.fng.mapper.StockMapper;
import com.upup.fng.mapper.StockOrderMapper;
import com.upup.fng.service.user.OrderService;
import com.upup.fng.user.po.Stock;
import com.upup.fng.user.po.StockOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/1/27 上午11:19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<StockMapper, Stock> implements OrderService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
    
    @Autowired
    private StockOrderMapper stockOrderMapper;
    
    @Override
    public int createWrongOrder(int sid) {
        //校验库存
        Stock stock = checkStock(sid);
        //扣库存
        saleStock(stock);
        //创建订单
        int id = createOrder(stock);
        return id;
    }

    private Stock checkStock(int sid) {
        Stock stock = this.getById(sid);
        if (stock.getSale() == stock.getCount()) {
            throw new RuntimeException("库存不足");
        }
        return stock;
    }

    private void saleStock(Stock stock) {
        stock.setSale(stock.getSale() + 1);
        this.baseMapper.updateById(stock);
    }

    private int createOrder(Stock stock) {
        StockOrder order = new StockOrder();
        order.setSid(stock.getId());
        order.setName(stock.getName());
        int id = this.stockOrderMapper.insert(order);
        return id;
    }

    @Override
    public int createOptimisticOrder(int sid) {
        //校验库存
        Stock stock = checkStock(sid);
        //乐观锁更新库存
        saleStockOptimistic(stock);
        //创建订单
        int id = createOrder(stock);
        return stock.getCount() - (stock.getSale()+1);
    }

    private void saleStockOptimistic(Stock stock) {
        LOGGER.info("查询数据库，尝试更新库存");
        int count = this.baseMapper.updateByOptimistic(stock);
        if (count == 0){
            throw new RuntimeException("并发更新库存失败，version不匹配") ;
        }
    }
}
