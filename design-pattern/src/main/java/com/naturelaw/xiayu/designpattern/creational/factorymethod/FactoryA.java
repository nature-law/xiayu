package com.naturelaw.xiayu.designpattern.creational.factorymethod;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/18 14:42
 */
public class FactoryA extends Factory{
	@Override
	public Product build() {
		return new ProductA();
	}
}
