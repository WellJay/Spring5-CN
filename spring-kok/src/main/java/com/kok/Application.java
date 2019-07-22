package com.kok;

import com.kok.config.AppConfig;
import com.kok.dao.UserDao1;
import com.kok.event.EmailService;
import com.kok.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wenjie
 * @description
 * @time 2019/7/1 0001 13:16
 */
public class Application {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		//System.out.println(ac.getBean("&mapper"));

//		UserDao1 bean = (UserDao1) ac.getBean("UserDao1");
//		bean.query();

		UserService userService = (UserService) ac.getBean(UserService.class);
		userService.hello();

//
//		EmailService bean1 = ac.getBean(EmailService.class);
//
//		bean1.sendEmail("1569925@qq.com", "hello");

	}

}
