package com.naturelaw.xiayu.designpattern.behavioral.template;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/20 13:11
 */
public class ConcreteA extends AbstractTemplate {
	@Override
	protected void doFirst() {
		System.out.print("我 ");
	}

	@Override
	protected void doNext() {
		System.out.print("爱 ");
	}

	@Override
	protected void doLast() {
		System.out.print("你 ！");
	}
}
