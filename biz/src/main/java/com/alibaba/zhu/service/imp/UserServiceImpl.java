package com.alibaba.zhu.service.imp;

import com.alibaba.zhu.dao.UserMapper;
import com.alibaba.zhu.domain.User;
import com.alibaba.zhu.exception.UserExistException;
import com.alibaba.zhu.service.UserService;
import com.alibaba.zhu.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * UserServiceImpl
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-08-29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapperDao;


    @Override
    public UserMapper getUserMapperDao() {
        return this.userMapperDao;
    }

    @Override
    public User getUserByID(Long id) {
        return userMapperDao.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapperDao.findByUserName(username);
    }

    //对web层提供注册服务
    public void register(User user) throws UserExistException {
        User u = userMapperDao.findByUserName(user.getUserName());
        if (u != null) {
            throw new UserExistException("用户已经存在！");
            //用户存在，给web层抛出编译时异常
        } else {
            user.setPassword(ServiceUtils.md5(user.getPassword()));
            userMapperDao.insert(user);
        }
    }

/*    //对web层提供登录服务
    public User login(String username,String password) {
        password = ServiceUtils.md5(password);
        return userMapperDao.findByUnamePsw(username, password);
    }*/

}
