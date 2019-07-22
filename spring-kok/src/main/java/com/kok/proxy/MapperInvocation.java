package com.kok.proxy;

import com.kok.annotation.Query;
import com.kok.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wenjie
 * @description
 * @time 2019/7/2 0002 9:41
 */
public class MapperInvocation implements InvocationHandler {


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//这儿获取sql注解执行sql语句
		String value = method.getDeclaredAnnotation(Query.class).value();
		System.out.println(value);
		return null;
	}
}
