package com.naturelaw.xiayu.designpattern.structural.composite;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/2 13:23
 */
public abstract class Component {

	public abstract void add(Component component);

	public abstract void remove(Component component);

	public abstract void doAction();
}
