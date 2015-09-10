package com.alibaba.zhu.app1.module.action;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.zhu.domain.User;
import com.alibaba.zhu.service.UserService;
import com.alibaba.zhu.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * LoginAction
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-09-09
 */
public class LoginAction {

    @Autowired
    private UserService userService;

    public void doLogin(@FormGroup("login") User user, Navigator nav) {

        User u = userService.getUserByUserName(user.getUserName());
        System.out.println(JSON.toJSONString(u));
        if (u != null && ServiceUtils.md5(user.getPassword()).equals(u.getPassword())) {
            System.out.println(u.getPassword());
            System.out.println(ServiceUtils.md5(user.getPassword()));
            nav.redirectTo("app1Link").withTarget("form/message").withParameter("message", "欢迎你，登录成功");

        }
        else{
            nav.redirectTo("app1Link").withTarget("form/login").withParameter("message", "用户名或密码错误，请重试");
        }
    }
}
