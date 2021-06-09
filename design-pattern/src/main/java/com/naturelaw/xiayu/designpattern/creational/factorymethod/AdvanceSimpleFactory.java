package com.naturelaw.xiayu.designpattern.creational.factorymethod;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/18 14:58
 */
public class AdvanceSimpleFactory extends Factory {
	@Override
	@Deprecated
	public Product build() {
		return null;
	}

	@Override
	public Product build(String name) {
		Product product = null;
		try {
			Class<Product> clazz = (Class<Product>) Class.forName(name);
			product = (Product) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return product;
	}
}
