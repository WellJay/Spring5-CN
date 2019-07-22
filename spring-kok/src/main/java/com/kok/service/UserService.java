package com.kok.service;

import com.kok.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenjie
 * @description
 * @time 2019/7/1 0001 13:17
 */
@Service
public class UserService {



	public UserService(AppConfig appConfig){
		System.out.println(appConfig);
	}

	public void hello(){
		System.out.println("hello" +
				"");
	}

}
