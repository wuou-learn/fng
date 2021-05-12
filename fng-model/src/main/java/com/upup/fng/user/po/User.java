package com.upup.fng.user.po;

import com.upup.fng.common.BaseEntity;
import lombok.Data;

/**
 * *****************************************
 * @author wuou [2020/7/30 上午11:35]
 * @version 5.0.0
 * *****************************************
 */
@Data
public class User extends BaseEntity {
    private String id;
    private String account;
    private String password;
}
