package com.upup.fng.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upup.fng.mapper.UserMapper;
import com.upup.fng.service.user.UserService;
import com.upup.fng.user.po.User;
import com.upup.fng.user.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * *****************************************
 * @author wuou [2020/7/30 上午11:44]
 * @version 5.0.0
 * *****************************************
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void login(UserVo userVo) {
        HashMap hashMap = new HashMap();
    }

    @Override
    public List<User> addUser(UserVo userVo) {
        this.save(userVo);
        List<User> list = this.list();
        return list;
    }
}
