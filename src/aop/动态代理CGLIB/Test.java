package aop.动态代理CGLIB;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args){

		//1.加载并且解析applicationContext.xml
		//积极加载，在加载与解析xml的同时，即完成所有bean的实例化
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("----------IOC容器加载完成--------------------");
		
		//2.无代理，无日志记录
		UserDaoImpl userDao7 = (UserDaoImpl)factory.getBean("userDao7");
		UserDaoImpl_2 userDao8 = (UserDaoImpl_2)factory.getBean("userDao8");
		DeptDaoImpl deptDao8 = (DeptDaoImpl)factory.getBean("deptDao8");
		//userDao7.selectUser();
		//userDao7.insertUser("张三");
		//userDao8.selectUser();
		//deptDao8.selectDept();
		
		//2.有代理，有日志记录 
		ProxyHandler proxyHandler7 = (ProxyHandler)factory.getBean("proxyHandler7");
		
		//代理对象proxyHandler5，实际对象userDao5
		UserDaoImpl proxy7 = (UserDaoImpl)proxyHandler7.bind(userDao7);
		proxy7.selectUser();
		//proxy7.insertUser("张德磊");
		
		DeptDaoImpl proxy8 = (DeptDaoImpl)proxyHandler7.bind(deptDao8);
		//proxy8.selectDept();
	}

}
