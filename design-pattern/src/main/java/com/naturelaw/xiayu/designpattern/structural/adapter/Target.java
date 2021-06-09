package com.naturelaw.xiayu.designpattern.structural.adapter;

/**
 * description: 使用一个已经存在的类，但如果它的接口，也就是它的方法和你的要求不相同时，就应该考虑用适配器模式。
 * 两个类所做的事情相同或类似，但是具有不同的接口时要使用它。
 *
 * @author Administrator
 * @date 2021/6/1 9:43
 */
public abstract class Target {
	public abstract void doAction();
}
