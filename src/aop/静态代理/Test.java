package aop.静态代理;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args){

		//1.加载并且解析applicationContext.xml
		//积极加载，在加载与解析xml的同时，即完成所有bean的实例化
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("----------IOC容器加载完成--------------------");
		
		//2.无代理，无日志记录
		IUserDao userDao = (IUserDao)factory.getBean("userDao3");
		IUserDao userDao2 = (IUserDao)factory.getBean("userDao4");
		//userDao.selectUser();
		//userDao.insertUser("张三");
		//userDao2.selectUser();
		
		//2.有代理，有日志记录 
		//代理对象proxyHandler3，实际对象userDao3
		ProxyHandler proxy = (ProxyHandler)factory.getBean("proxyHandler3");
		proxy.insertUser("张三");
		proxy.selectUser();
		
		//代理对象proxyHandler4，实际对象userDao4
		ProxyHandler proxy4 = (ProxyHandler)factory.getBean("proxyHandler4");
		proxy4.insertUser("李四");
		proxy4.selectUser();
		
	}

}
