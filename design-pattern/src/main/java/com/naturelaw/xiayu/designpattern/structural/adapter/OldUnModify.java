package com.naturelaw.xiayu.designpattern.structural.adapter;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/1 9:44
 */
public class OldUnModify extends Target {
	@Override
	public void doAction() {
		System.out.println("这是一个已经存在的旧类");
	}
}
