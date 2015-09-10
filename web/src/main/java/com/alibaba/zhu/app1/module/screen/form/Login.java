package com.alibaba.zhu.app1.module.screen.form;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.zhu.domain.User;

/**
 * Login
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-09-09
 */
public class Login {

    public void execute(@Param("message") String message, Context context) {
        //回显数据
  /*      if (message.length >= 1) {
            User user = JSONObject.parseObject(message[0], User.class);
            context.put("user", user);
            context.put("message", message[1]);
        }*/
        context.put("message", message);
    }
}
