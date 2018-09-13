package com.dao;

import com.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}