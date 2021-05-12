package com.upup.fng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.upup.fng.user.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * *****************************************
 * @author wuou [2020/7/30 上午11:45]
 * @version 5.0.0
 * *****************************************
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select *.u from user u where u.account=:account")
    public User queryByAccount(@Param("account") String account);
}
