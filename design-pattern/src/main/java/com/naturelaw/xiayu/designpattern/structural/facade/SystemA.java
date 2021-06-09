package com.naturelaw.xiayu.designpattern.structural.facade;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 13:33
 */
public class SystemA {
	public void doActionA() throws NoSuchMethodException {
		System.out.println(this.getClass().getSimpleName() + " -> " + this.getClass().getMethod("doActionA").getName());
	}
}
