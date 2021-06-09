package com.naturelaw.xiayu.designpattern.structural.proxy;

/**
 * description:
 * 优点：在不修改目标对象(被代理对象)的功能前提下, 能通过代理对象对目标功能扩展
 * 缺点：因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类
 * 一旦接口增加方法,目标对象与代理对象都要维护
 *
 * @author Administrator
 * @date 2021/6/3 9:31
 */
public class StaticProxy implements Subject {
	private Subject subject;

	public StaticProxy(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void doAction() {
		System.out.println("权限 -> 扫码测温");
		System.out.println("缓存代理 -> 可以正常去通过隔离区");
		System.out.println("远程代理 -> 需要通过网络访问 -> 你找的人在B栋201");
		subject.doAction();
	}
}
