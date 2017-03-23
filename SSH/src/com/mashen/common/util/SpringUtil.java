package com.mashen.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext ctx;
	static{
		init("application.xml");
	}
	public static void init(String xmlpath){
		ctx=new ClassPathXmlApplicationContext(xmlpath);
	}
	
	public static Object getBean(String id){
		return ctx.getBean(id);
	}
	public static <T> T  getBean(Class<T> type){
		return ctx.getBean(type);
	}
	public static void main(String[] args) {
		SpringUtil.init("application.xml");
	}
}
