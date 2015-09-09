/*
 * Copyright (c) 2002-2012 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.zhu.app1.module.action;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.zhu.domain.User;
import com.alibaba.zhu.exception.UserExistException;
import com.alibaba.zhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

//处理用户提交的表单数据，此步可跳过。
public class RegisterAction {

    @Autowired
    private UserService userService;

    public void doRegister(@FormGroup("register") User user, Navigator nav) {


        //user.setId(WebUtils.generateID());
        try {
            //3.校验成功，则调用service处理注册请求
            userService.register(user);
            //6.service处理成功，跳转到网站的全局消息显示页面，为用户显示注册成功消息
            nav.redirectTo("app1Link").withTarget("form/message").withParameter("message", user.getNickname() + "--注册成功");
            return;
        } catch (UserExistException e) {
            //4.service处理不成功，原因是用户存在跳回注册页面显示注册用户已存在
            nav.redirectTo("app1Link").withTarget("form/register").withParameter("message", JSON.toJSONString(user), "用户已存在");
            return;
        } catch (Exception e) {
            //5.service处理不成功，原因是其他问题   ，跳转到全局消息处理界面，显示友好错误页面
            e.printStackTrace();
            nav.redirectTo("app1Link").withTarget("form/message").withParameter("message", "服务器出现未知错误");
            return;
        }
      /*  Form form = formService.getForm();
        Group group = form.getGroup("register");
        Field field = group.getField("birthday");
        String birth = (String) field.getValue();*/

        // nav.redirectTo("app1Link").withTarget("form/welcome").withParameter("name", user.getNickname(),JSON.toJSONString(user)+"--注册成功");
    }
}
