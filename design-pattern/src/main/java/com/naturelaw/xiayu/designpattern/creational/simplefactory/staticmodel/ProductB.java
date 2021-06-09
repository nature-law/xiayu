package com.naturelaw.xiayu.designpattern.creational.simplefactory.staticmodel;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/18 13:40
 */
public class ProductB extends Product {
	@Override
	public void action() {
		System.out.println("Hello " + ProductB.class.getSimpleName());
	}
}
