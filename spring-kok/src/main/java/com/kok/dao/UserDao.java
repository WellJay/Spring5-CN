package com.kok.dao;

import com.kok.annotation.Query;
import org.springframework.stereotype.Repository;

/**
 * @author wenjie
 * @description
 * @time 2019/7/2 0002 9:31
 */
//@Repository
public interface UserDao {

	@Query("SELECT * FROM t_user")
	void query();

}
