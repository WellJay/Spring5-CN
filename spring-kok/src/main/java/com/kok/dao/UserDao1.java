package com.kok.dao;

import com.kok.annotation.Query;

/**
 * @author wenjie
 * @description
 * @time 2019/7/2 0002 9:31
 */
//@Repository
public interface UserDao1 {

	@Query("SELECT * FROM t_user1")
	void query();

}
