package com.naturelaw.xiayu.designpattern.behavioral.responsebility;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/31 9:29
 */
public class ConcreteHandlerB extends Handler {
	@Override
	public void handler() {
		System.out.println(this.getClass().getSimpleName());
		nextHandler.handler();
	}
}
