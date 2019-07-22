package com.kok.beanFactory;

import com.kok.dao.UserDao;
import com.kok.proxy.MapperInvocation;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author wenjie
 * @description
 * @time 2019/7/2 0002 9:39
 */
//@Component("mapper")
public class MapperFactoryBean implements FactoryBean {

	Class mapperInterface;

	public MapperFactoryBean(Class mapperInterface){
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		Class[] clazz = new Class[]{mapperInterface};
		MapperInvocation mapperInvocation = new MapperInvocation();
		return Proxy.newProxyInstance(MapperInvocation.class.getClassLoader(), clazz, mapperInvocation);
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}



}
