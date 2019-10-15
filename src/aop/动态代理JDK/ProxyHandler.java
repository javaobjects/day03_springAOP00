package aop.动态代理JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 * 
* <p>Title: ProxyHandler</p>  
* <p>
*	Description: 
* 	动态代理：代理所有实现了同一接口的实现类，适用于所有的接口类型
*   
* </p> 
* @author xianxian 
* @date 2019年10月14日
 */
public class ProxyHandler implements InvocationHandler {

	//实际对象
	private Object obj;
	
	//传入实际对象，且返回代理对象
	public Object bind(Object obj)
	{
		//实际对象
		this.obj = obj;
		
		/**
		 * 根据实际对象 -> 代理对象
		 * 		参数：
					loader - 定义代理类的类加载器
					interfaces - 代理类要实现的接口列表
					h - 指派方法调用的调用处理程序 
		 */
		return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(), this.obj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用方法的对象：" + this.obj.getClass().getName());
		System.out.println("调用的方法名称：" + method.getName());
		System.out.println("调用方法传递的参数：" + Arrays.toString(args));
		
		//真正的核心逻辑代码，调用实际对象的方法
		Object returnValue = method.invoke(this.obj, args);
		
		System.out.println("调用方法的返回值：" + returnValue);
		
		return returnValue;
	}
}
