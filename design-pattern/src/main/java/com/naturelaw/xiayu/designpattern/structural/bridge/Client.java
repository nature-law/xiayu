package com.naturelaw.xiayu.designpattern.structural.bridge;

/**
 * description: 桥接模式是合成复用原则的强烈体现
 * 桥接模式的思想是将抽象和实现的过程分离，让它们各自的变化。这就使得每种实现的变化不会影响其它的实现，从而达到应对变化的目的。
 * 桥接模式的目的是使用  使用聚合的方式代替继承， 以解决耦合的问题， 是高内聚， 低耦合的重要体现
 * @author Administrator
 * @date 2021/6/1 11:24
 */
public class Client {
	public static void main(String[] args) {
		Implementor implementorA = new ConcreteImplA();
		Implementor implementorB = new ConcreteImplB();
		Abstraction abstraction = new RedefineAbstraction();
		abstraction.setImplementor(implementorA);
		abstraction.execute();

		abstraction.setImplementor(implementorB);
		abstraction.execute();
	}
}
