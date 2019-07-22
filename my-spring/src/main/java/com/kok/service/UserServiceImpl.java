package com.kok.service;

import com.kok.dao.UserDao;

/**
 * @author wenjie
 * @description
 * @date 2019/7/13 14:08
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public void getUser() {
        System.out.println("user service --- getUser()");
        userDao.query();
    }

}
