package com.upup.fng.web.controller;

import com.upup.fng.engine.i18n.I18nContext;
import com.upup.fng.engine.i18n.I18nKey;
import com.upup.fng.engine.log.Log;
import com.upup.fng.engine.log.LogLevel;
import com.upup.fng.engine.log.LogTag;
import com.upup.fng.engine.model.dto.Result;
import com.upup.fng.service.user.HelloTest;
import com.upup.fng.service.user.UserService;
import com.upup.fng.user.po.User;
import com.upup.fng.user.vo.UserVo;
import com.upup.fng.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * *****************************************
 * @author wuou [2020/7/29 下午2:12]
 * @version 5.0.0
 * *****************************************
 */
@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController<User, UserVo, UserService> {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @RequestMapping("/user")
    @LogTag(LOG = Log.OPERATE, LEVEL = LogLevel.ERROR)
    public Result test(){
        String message = I18nContext.get("ch",I18nKey.UPLOAD_FAILED);
        this.json().setMsg(message);
        this.json().setList(service().list());
        return this.json();
    }

    @RequestMapping("/redis")
    public Result test2(){
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        operations.set("fng", "test");
        Object fng = operations.get("fng");
        this.json().setBean(fng);
        return this.json();
    }
    
    @RequestMapping("/add")
    public Result add(){
        long start = System.currentTimeMillis();
        HelloTest.conn();
        long end = System.currentTimeMillis();
        this.json().setMsg("耗时：" + (end - start)/1000 + "秒");
        return this.json();
    }
}
