package com.kok.spring;

import com.kok.beanFactory.MapperFactoryBean;
import com.kok.dao.UserDao;
import com.kok.dao.UserDao1;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wenjie
 * @description 可以动态的往SpringFactory的beanDefinitionMap中添加BeanDefinition
 * @time 2019/7/2 0002 9:59
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		//扫描得到包里面带有mapper注解的类
		Class[] clazz = new Class[]{UserDao.class, UserDao1.class};

		for (Class aClass : clazz) {
			//spring scan
			BeanDefinitionBuilder beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(aClass);

			AbstractBeanDefinition abstractBeanDefinition = beanDefinition.getBeanDefinition();

			//代理对象
			abstractBeanDefinition.setBeanClass(MapperFactoryBean.class);

			abstractBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(aClass);
			//放入ioc
			registry.registerBeanDefinition(aClass.getSimpleName(), abstractBeanDefinition);
		}

	}
}
