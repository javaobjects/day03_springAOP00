package aop.动态代理CGLIB;

public class UserDaoImpl_2{

	public UserDaoImpl_2()
	{
		System.out.println("new UserDaoImpl_2() 实例化");
	}
	
	public void selectUser() {
		//System.out.println("UserDaoImpl_2.selectUser()............日志记录开始");
		
		System.out.println("UserDaoImpl_2.selectUser..........玉艺22222");
		
		//System.out.println("UserDaoImpl_2.selectUser()............日志记录结束");
	}

	public boolean insertUser(String username) {
		//System.out.println("UserDaoImpl_2.insertUser("+username+")............日志记录开始");
		
		System.out.println("UserDaoImpl_2.insertUser("+username+")");
		
		//System.out.println("UserDaoImpl_2.insertUser()............日志记录开始,返回结果：" + true);
		
		return true;
	}
}
