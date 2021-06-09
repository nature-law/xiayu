package com.naturelaw.xiayu.designpattern.creational.builder;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/20 10:53
 */
public class Director<T> {
	public void directBuilder(Builder<T> builder) {
		builder.buildPartA();
		builder.buildPartB();
	}
}
