package com.naturelaw.xiayu.designpattern.creational.factorymethod;

/**
 * description: 将具体工厂的实现变为简单工厂模式 + 反射， 就更简化了， 不需要每次再重新创建新的工厂类了， 工厂方法模式比简单工厂的提升就是实现了
 * 开闭原则， 简单工厂是不符合开闭原则的， 因为创建过程是在工厂里实现的， 增加产品类别是需要修改工厂的。
 *
 * @author Administrator
 * @date 2021/5/18 14:43
 */
public class Client {
	public static void main(String[] args) {
		Factory factory = new FactoryA();
		Product product = factory.build();
		product.doAction();
		Factory factoryB = new FactoryB();
		Product productB = factoryB.build();
		productB.doAction();

		// 高级用法
		Factory advanceFactory = new AdvanceSimpleFactory();
		advanceFactory.build(ProductA.class.getName()).doAction();
		advanceFactory.build(ProductB.class.getName()).doAction();
	}
}
