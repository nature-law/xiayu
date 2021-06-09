package com.naturelaw.xiayu.designpattern.creational.abstractfactory;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/19 10:56
 */
public class ConcreteFactoryA extends Factory{

	@Override
	public AbstractProductA produceA() {
		return new ConcreteProductA();
	}

	@Override
	public AbstractProductB productB() {
		return new ConcreteProductB();
	}
}
