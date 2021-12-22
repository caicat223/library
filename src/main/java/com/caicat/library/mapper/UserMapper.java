package com.caicat.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caicat.library.entity.User;

public interface UserMapper extends BaseMapper<User> {
    //用户登录
    User Login(User user);
}
