package com.naturelaw.xiayu.designpattern.structural.bridge;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/1 11:32
 */
public abstract class Abstraction {
	protected Implementor implementor;

	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}

	public abstract void execute();

}
