package com.naturelaw.xiayu.designpattern.creational.abstractfactory;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/19 10:49
 */
public class ConcreteProductA extends AbstractProductA{

	@Override
	public void look() {
		System.out.println("我看见你了");
	}
}
