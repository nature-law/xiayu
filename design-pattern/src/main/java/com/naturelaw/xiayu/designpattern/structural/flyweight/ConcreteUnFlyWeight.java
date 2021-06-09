package com.naturelaw.xiayu.designpattern.structural.flyweight;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 13:57
 */
public class ConcreteUnFlyWeight extends FlyWeight {
	@Override
	public void doAction() {
		System.out.println("非共享的 ->" + this.getClass().getSimpleName());
	}
}
