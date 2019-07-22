package com.kok.test;

import com.kok.factory.BeanFactory;
import com.kok.service.UserService;

/**
 * @author wenjie
 * @description
 * @date 2019/7/13 14:18
 */
public class Tester {

    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUser();
    }

}
