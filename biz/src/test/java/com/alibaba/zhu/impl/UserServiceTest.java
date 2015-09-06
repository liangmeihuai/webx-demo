package com.alibaba.zhu.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.zhu.AbstractComponentTest;
import com.alibaba.zhu.domain.User;
import com.alibaba.zhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.alibaba.zhu.utils.ServiceUtils.md5;

/**
 * UserServiceTest
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-08-27
 */
public class UserServiceTest extends AbstractComponentTest {

    @Autowired
    private UserService userService;


    @Test
    public void testGetUserByID() {
        User user = userService.getUserByID(2L);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void testGetUserByUserName() {

        User user = userService.getUserByUserName("zhu");
        System.out.println(JSON.toJSONString(user));

    }



    @Test
    public void testInset() throws ParseException {

        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        String dateStringToParse = "2001-9-29";
        Date date = bartDateFormat.parse(dateStringToParse);

        User user = new User();
        user.setId(2L);
        user.setBirthday(date);
        user.setEmail("1664676868@qq.com");
        user.setNickname("燕子");
        user.setUserName("xiaozhu");
        user.setPassword(md5("123"));
        userService.getUserMapperDao().insert(user);
        Assert.assertNotNull(userService.getUserByID(2L));
        System.out.println(JSON.toJSONString(userService.getUserByID(1L)));
        System.out.println(JSON.toJSONString(userService.getUserByID(2L)));

    }

}
