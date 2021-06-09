package com.naturelaw.xiayu.designpattern.creational.simplefactory.base;

/**
 * description: 简单工厂
 *
 * @author Administrator
 * @date 2021/5/18 13:25
 */
public class Factory {
	/**
	 * description： 生产产品
	 */
	public Product build(String name) {
		Product product = null;
		switch (name) {
			case "ProductA":
				product = new ProductA();
				break;
			case "ProductB":
				product = new ProductB();
				break;
			default:
				product = new ProductA();
				break;
		}
		return product;
	}
}
