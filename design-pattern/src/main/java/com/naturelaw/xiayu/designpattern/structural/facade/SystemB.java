package com.naturelaw.xiayu.designpattern.structural.facade;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 13:34
 */
public class SystemB {
	public void doActionB() throws NoSuchMethodException {
		System.out.println(this.getClass().getSimpleName() + " -> " + this.getClass().getMethod("doActionB").getName());
	}
}
