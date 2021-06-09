package com.naturelaw.xiayu.designpattern.creational.abstractfactory;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/19 10:59
 */
public class ConcreteFactoryB extends Factory {
	@Override
	public AbstractProductA produceA() {
		return new ConcreteProductAA();
	}

	@Override
	public AbstractProductB productB() {
		return new ConcreteProductBB();
	}
}
