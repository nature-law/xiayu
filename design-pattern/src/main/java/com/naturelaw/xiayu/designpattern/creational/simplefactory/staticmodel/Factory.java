package com.naturelaw.xiayu.designpattern.creational.simplefactory.staticmodel;

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
	public static Product build(String name) {
		Product product = null;
		Class<?> clazz = null;
		try {
			clazz = Class.forName(name);
			Object o = clazz.newInstance();
			if (o instanceof Product) {
				product = (Product) o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}
}
