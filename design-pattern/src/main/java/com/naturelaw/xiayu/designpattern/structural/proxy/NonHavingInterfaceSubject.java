package com.naturelaw.xiayu.designpattern.structural.proxy;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/3 10:43
 */
public class NonHavingInterfaceSubject {
	public void doAction() {
		System.out.println("真实的Subject, 但是没有实现接口");
	}
}
