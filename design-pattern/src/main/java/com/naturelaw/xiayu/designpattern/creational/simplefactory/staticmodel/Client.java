package com.naturelaw.xiayu.designpattern.creational.simplefactory.staticmodel;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/18 13:43
 */
public class Client {
	public static void main(String[] args) {
		Product productA = Factory.build(ProductA.class.getName());
		Product productB = Factory.build(ProductA.class.getName());
		productA.action();
		productB.action();
	}
}
