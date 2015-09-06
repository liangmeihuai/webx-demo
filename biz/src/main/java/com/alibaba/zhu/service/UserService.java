package com.alibaba.zhu.service;

import com.alibaba.zhu.dao.UserMapper;
import com.alibaba.zhu.domain.User;
import com.alibaba.zhu.exception.UserExistException;
import org.springframework.stereotype.Component;

/**
 * UserService
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-08-26
 */
@Component
public interface UserService {
     UserMapper getUserMapperDao();
     User getUserByID(Long id);
     User getUserByUserName(String username);
     void register(User user) throws UserExistException;
}
