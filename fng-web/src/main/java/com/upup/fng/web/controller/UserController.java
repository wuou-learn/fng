package com.upup.fng.web.controller;

import com.upup.fng.engine.log.LogPoint;
import com.upup.fng.engine.log.LogTag;
import com.upup.fng.engine.model.dto.Result;
import com.upup.fng.service.user.UserService;
import com.upup.fng.user.po.User;
import com.upup.fng.user.vo.UserVo;
import com.upup.fng.web.common.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/7/31 下午4:58
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, UserVo, UserService> {

    @LogTag(POINTS = {LogPoint.BEFORE,LogPoint.AFTER,LogPoint.THROW})
    @RequestMapping("/login")
    public Result login(){
        System.out.println("controller---》进来了");
        this.service().login(null);
        return json();
    }

}
