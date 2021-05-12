package com.upup.fng.engine.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/20 下午4:52
 */
@Component
public class FngLogImpl implements FngLog{
    
    Logger logger = LoggerFactory.getLogger(FngLogImpl.class);
    
    @Override
    public void error(String info) {
        logger.error(info);
    }
   
}
