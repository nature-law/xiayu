package com.naturelaw.xiayu.designpattern.creational.builder;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/20 10:37
 */
public abstract class Builder<T> {

	protected abstract void buildPartA();

	protected abstract void buildPartB();

	public abstract T getProduct();
}
