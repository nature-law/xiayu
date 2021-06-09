package com.naturelaw.xiayu.designpattern.structural.proxy;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/3 9:32
 */
public class RealSubject implements Subject {
	@Override
	public void doAction() {
		System.out.println("真实的Subject");
	}
}
