package com.naturelaw.xiayu.designpattern.structural.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/3 10:44
 */
public class CglibProxy<T> implements MethodInterceptor {

	private T target;

	public CglibProxy(T target) {
		this.target = target;
	}

	public T getInstance() {
		//返回一个代理对象: 是 target 对象的代理对象
		//1. 创建一个工具类
		Enhancer enhancer = new Enhancer();
		//2. 设置父类
		enhancer.setSuperclass(target.getClass());
		//3. 设置回调函数
		enhancer.setCallback(this);
		//4. 创建子类对象，即代理对象
		return (T) enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object invoke = method.invoke(target, args);
		return invoke;
	}
}
