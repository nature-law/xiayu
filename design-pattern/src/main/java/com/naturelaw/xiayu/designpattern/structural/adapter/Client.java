package com.naturelaw.xiayu.designpattern.structural.adapter;

/**
 * description:结构型模式的目的是， 在不修改现有类的前提下，通过多态以及组合聚合的方式，进行多个类之间的结构进行设计，
 * 以达到功能和属性的扩展的，以及对已有对象或类进行功能的扩展， 以及对现有类的结构进行组合
 *
 * 使用一个已经存在的类，但如果它的接口，也就是它的方法和你的要求不相同时，就应该考虑用适配器模式。
 * 两个类所做的事情相同或类似，但是具有不同的接口时要使用它。
 * 适配器模式的作用是改造现有的结构， 且不能够通过原始的设计达到变更的目的， 以同样的行为来， 达到目录。
 *
 * @author Administrator
 * @date 2021/6/1 11:03
 */
public class Client {
	public static void main(String[] args) {
		Target target1 = new Adapter();
		Target target2 = new OldUnModify();
		target1.doAction();
		target2.doAction();
	}
}
