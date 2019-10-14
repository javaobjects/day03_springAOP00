package aop.静态代理;
/**
 * 静态代理：代理所有实现了同一接口IUserDao的实现类
 */
public class ProxyHandler implements IUserDao {

	//实际对象
	private IUserDao userDao;
	
	public ProxyHandler(IUserDao userDao)
	{
		this.userDao = userDao;
	}
	
	@Override
	public void selectUser() {
		System.out.println(userDao.getClass().getName() + ".selectUser()............日志记录开始");
		
		//真正的核心逻辑代码，调用实际对象的方法
		userDao.selectUser();
		
		System.out.println(userDao.getClass().getName() + ".selectUser()............日志记录结束");
	}

	@Override
	public boolean insertUser(String username) {
		System.out.println(userDao.getClass().getName() + ".insertUser("+username+")............日志记录开始");
		
		//真正的核心逻辑代码，调用实际对象的方法
		boolean result = userDao.insertUser(username);
		
		System.out.println(userDao.getClass().getName() +  ".insertUser()............日志记录开始,返回结果：" + result);
		
		return result;
	}
}
