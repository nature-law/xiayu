package com.naturelaw.xiayu.designpattern.structural.flyweight;

/**
 * description: 如果说单例模式是控制一个类的自我实例， 那么享元模式控制的则是一系列的类的实例， 享元模式中实现了一堆的单例模式
 *
 * @author Administrator
 * @date 2021/6/4 13:45
 */
public class Client {
	public static void main(String[] args) {
		FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
		FlyWeight a = flyWeightFactory.getFlyWeight("A");
		a.doAction();
		FlyWeight flyWeight = new ConcreteUnFlyWeight();
		flyWeight.doAction();
	}
}
