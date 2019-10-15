package aop.动态代理CGLIB;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


/**
 * 
* <p>Title: ProxyHandler</p>  
* <p>
*	Description: 
* 	动态代理（CGLIB）：代理所有没有实现接口的类
*   
* </p> 
* @author xianxian 
* @date 2019年10月14日
 */
public class ProxyHandler implements MethodInterceptor {

	//实际对象
	private Object obj;
	
	//传入实际对象，且返回代理对象
	public Object bind(Object obj)
	{
		//实际对象
		this.obj = obj;
		
		/**
		 * 根据实际对象 -> 代理对象 
		 */
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.obj.getClass());//设置父类
		enhancer.setCallback(this);//设置调用方法的时候，被哪一个对象的intercept方法拦截
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("调用方法的对象：" + this.obj.getClass().getName());
		System.out.println("调用的方法名称：" + method.getName());
		System.out.println("调用方法传递的参数：" + Arrays.toString(args));
		
		//真正的核心逻辑代码，调用实际对象的方法
		Object returnValue = method.invoke(this.obj, args);
		
		System.out.println("调用方法的返回值：" + returnValue);
		
		return returnValue;
	}
}
