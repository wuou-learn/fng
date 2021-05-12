package com.upup.fng.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.upup.fng.user.po.User;
import com.upup.fng.user.vo.UserVo;

import java.util.List;

public interface UserService extends IService<User> {

    public void login(UserVo userVo);
    
    public List<User> addUser(UserVo userVo);
}
