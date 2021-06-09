package com.naturelaw.xiayu.designpattern.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/3 10:05
 */
public class DynamicProxy<T> {
	private T target;

	public DynamicProxy(T target) {
		this.target = target;
	}

	/**
	 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
	 * 1. ClassLoader loader ： 指定当前目标对象使用的类加载器, 获取加载器的方法固定
	 * 2. Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
	 * 3. InvocationHandler h : 事情处理，执行目标对象的方法时，会触发事情处理器方***把当前执行的目标对象方法作为参数传入
	 */
	public T getTargetInstance() {
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				(proxy, method, args) -> {
					System.out.println("JDK 动态代理");
					return method.invoke(target, args);
				});
		return (T) obj;
	}

}
