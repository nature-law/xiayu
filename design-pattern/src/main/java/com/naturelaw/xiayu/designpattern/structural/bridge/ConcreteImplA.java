package com.naturelaw.xiayu.designpattern.structural.bridge;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/1 13:50
 */
public class ConcreteImplA extends Implementor {
	@Override
	public void doAction() {
		System.out.println("ConcreteImplA");
	}
}
