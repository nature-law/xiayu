package com.naturelaw.xiayu.designpattern.creational.factorymethod;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/18 14:40
 */
public abstract class Factory {
	public abstract Product build();

	public Product build(String className) {
		return null;
	}
}
