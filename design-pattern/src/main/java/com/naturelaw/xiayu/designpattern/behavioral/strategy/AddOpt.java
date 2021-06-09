package com.naturelaw.xiayu.designpattern.behavioral.strategy;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/21 10:49
 */
public class AddOpt extends Strategy {

	@Override
	public int executeAlgorithm(int a, int b) {
		return a + b;
	}
}
