package com.naturelaw.xiayu.designpattern.creational.simplefactory.base;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/18 13:39
 */
public class ProductA extends Product {
	@Override
	public void action() {
		System.out.println("Hello " + ProductA.class.getSimpleName());
	}
}
