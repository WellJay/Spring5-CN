package com.kok.test;

import com.kok.app.Appconfig;
import com.kok.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext(Appconfig.class);
		//Appconfig appconfig = annotationConfigApplicationContext.getBean(Appconfig.class);

		annotationConfigApplicationContext.getBean(IndexService.class);
//		Appconfig appcofig = new Appconfig();
//		appcofig.testProxy();
//		appcofig.testProxy();

//
//		Enhancer enhancer = new Enhancer();
//		//增强父类，地球人都知道cglib是基于继承来的
//		enhancer.setSuperclass(Appcofig.class);
//
//		//不继承Factory接口
//		enhancer.setUseFactory(false);
//		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
//		// BeanFactoryAwareGeneratorStrategy是一个生成策略
//		// 主要为生成的CGLIB类中添加成员变量$$beanFactory
//		// 同时基于接口EnhancedConfiguration的父接口BeanFactoryAware中的setBeanFactory方法，
//		// 设置此变量的值为当前Context中的beanFactory,这样一来我们这个cglib代理的对象就有了beanFactory
//		//有了factory就能获得对象，而不用去通过方法获得对象了，因为通过方法获得对象不能控制器过程
//		//该BeanFactory的作用是在this调用时拦截该调用，并直接在beanFactory中获得目标bean
//		//enhancer.setStrategy(new ConfigurationClassEnhancer.BeanFactoryAwareGeneratorStrategy(classLoader));
//		//过滤方法，不能每次都去new
//		enhancer.setCallback(new MyCallback());
//
//		Appcofig chil = (Appcofig) enhancer.create();
//		chil.testProxy();
//
//		chil.testProxy();


	}
}
