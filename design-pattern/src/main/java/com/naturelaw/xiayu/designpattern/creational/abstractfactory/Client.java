package com.naturelaw.xiayu.designpattern.creational.abstractfactory;

/**
 * description: 抽象工厂与工厂方法模式不同点在于， 抽象工厂是对一系列产品的构建， 一个工厂里同时可以生产多个产品， 或者说一个工厂里一次可以生产一个系列的产品
 * 比如说 一个mysql工厂的Driver, Connection, UserInfo, 另一个Oracle工厂则需要生产不同的但是同类的信息； 而工厂方法模式则是一个工厂里同时只能生产一个产品。
 * 所以抽象工厂的使用前提应该是只有存在两个类型的产品，如果只有一个类型的产品则工厂方法模式和抽象工厂一致。 （可以用简单方法模式和反射对的工厂进行改造）
 *
 * @author Administrator
 * @date 2021/5/19 11:00
 */
public class Client {
	public static void main(String[] args) {
		Factory factoryA = new ConcreteFactoryA();
		factoryA.produceA().look();
		factoryA.productB().say();

		Factory factoryB = new ConcreteFactoryB();
		factoryB.produceA().look();
		factoryB.productB().say();
	}

}
