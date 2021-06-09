package com.naturelaw.xiayu.designpattern.behavioral.template;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/20 13:11
 */
public class ConcreteB extends AbstractTemplate {
	@Override
	protected void doFirst() {
		System.out.print("I ");
	}

	@Override
	protected void doNext() {
		System.out.print("Love ");
	}

	@Override
	protected void doLast() {
		System.out.print("You !");
	}
}
