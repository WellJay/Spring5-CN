package com.kok.dao;

/**
 * @author wenjie
 * @description
 * @date 2019/7/13 14:06
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void query() {
        System.out.println("select * from t_user;");
    }
}
