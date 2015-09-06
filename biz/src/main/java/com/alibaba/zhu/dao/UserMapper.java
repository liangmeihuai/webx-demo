package com.alibaba.zhu.dao;

import com.alibaba.zhu.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);





    User findByUserName(String name);
   // User findByUnamePsw(String username,String password);
}