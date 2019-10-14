package aop.动态代理JDK;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args){

		//1.加载并且解析applicationContext.xml
		//积极加载，在加载与解析xml的同时，即完成所有bean的实例化
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("----------IOC容器加载完成--------------------");
		
		//2.无代理，无日志记录
		IUserDao userDao5 = (IUserDao)factory.getBean("userDao5");
		IUserDao userDao6 = (IUserDao)factory.getBean("userDao6");
		IDeptDao deptDao = (IDeptDao)factory.getBean("deptDao");
		userDao5.selectUser();
		//userDao5.insertUser("张三");
		//userDao6.selectUser();
		//deptDao.selectDept();
		
		//2.有代理，有日志记录 
		ProxyHandler proxyHandler5 = (ProxyHandler)factory.getBean("proxyHandler5");
		
		//代理对象proxyHandler5，实际对象userDao5
		IUserDao proxy5 = (IUserDao)proxyHandler5.bind(userDao5);
		//proxy5.selectUser();
		//proxy5.insertUser("张德磊");
		
		IDeptDao proxy6 = (IDeptDao)proxyHandler5.bind(deptDao);
		proxy6.selectDept();
	}

}
