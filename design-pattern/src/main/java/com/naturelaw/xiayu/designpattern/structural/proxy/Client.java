package com.naturelaw.xiayu.designpattern.structural.proxy;

/**
 * description:
 * <p>
 * 防火墙代理
 * 内网通过代理穿透防火墙，实现对公网的访问。
 * <p>
 * 缓存代理
 * 比如：当请求图片文件等资源时，先到缓存代理取，如果取到资源则 ok,如果取不到资源，再到公网或者数据库取，然后缓存。
 * <p>
 * 远程代理
 * 远程对象的本地代表，通过它可以把远程对象当本地对象来调用。远程代理通过网络和真正的远程对象沟通信息。
 * <p>
 * 同步代理：主要使用在多线程编程中，完成多线程间同步工作
 *
 * @author Administrator
 * @date 2021/6/3 9:36
 */
public class Client {
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		Subject staticProxy = new StaticProxy(subject);
		staticProxy.doAction();

		// 动态代理
		Subject realSubject = new RealSubject();
		DynamicProxy<Subject> dynamicProxy = new DynamicProxy<>(realSubject);
		dynamicProxy.getTargetInstance().doAction();

		// Cglib 代理
		NonHavingInterfaceSubject subject1 = new NonHavingInterfaceSubject();
		CglibProxy<NonHavingInterfaceSubject> subjectCglibProxy = new CglibProxy<>(subject1);
		subjectCglibProxy.getInstance().doAction();
	}
}
