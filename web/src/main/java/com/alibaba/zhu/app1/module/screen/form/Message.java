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

package com.alibaba.zhu.app1.module.screen.form;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.zhu.domain.User;
import com.alibaba.zhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//screen通常是读取数据库，把模板需要的对象放context中
public class Message {
    public void execute(@Param("message") String message, Context context) {

        context.put("message", message);
    }
}
