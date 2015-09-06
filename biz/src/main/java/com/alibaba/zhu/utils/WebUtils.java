package com.alibaba.zhu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

    public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
        try {
            T bean = beanClass.newInstance();
            Enumeration e = request.getParameterNames();
            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyBean(Object src, Object dest) {
        /*
         * private String username; private String password; private String password2; private String email; private
         * String birthday; private String nickname; private String id; private String username; private String
         * password; private String email; private Date birthday; private String nickname;
         */
        ConvertUtils.register(new Converter() {

            @Override
            public Object convert(Class type, Object value) {
                if (value == null) return null;
                String str = (String) value;
                if (str.trim().equals("")) return null;
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return df.parse(str.trim());
                } catch (ParseException e) {
                    throw new RuntimeException();
                }
            }
        }, Date.class);
        try {
            BeanUtils.copyProperties(dest, src);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }// 产生全世界唯一的id

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

}
