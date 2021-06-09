package com.naturelaw.xiayu.designpattern.creational.simplefactory.base;

/**
 * description: 简单工厂的好处， 不需要客户端类负责创建具体的产品实例了，
 *
 * @author Administrator
 * @date 2021/5/18 13:43
 */
public class Client {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Product productA = factory.build(ProductA.class.getSimpleName());
		Product productB = factory.build(ProductB.class.getSimpleName());
		productA.action();
		productB.action();
	}
}
