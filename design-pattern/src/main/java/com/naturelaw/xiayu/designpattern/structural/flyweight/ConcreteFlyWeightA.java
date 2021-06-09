package com.naturelaw.xiayu.designpattern.structural.flyweight;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 13:53
 */
public class ConcreteFlyWeightA extends FlyWeight {
	@Override
	public void doAction() {
		System.out.println("可分享的" + this.getClass().getSimpleName());
	}
}
