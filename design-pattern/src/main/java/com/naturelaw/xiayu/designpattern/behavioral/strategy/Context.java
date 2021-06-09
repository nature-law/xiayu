package com.naturelaw.xiayu.designpattern.behavioral.strategy;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/21 9:44
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int doAlgorithm(int a, int b) {
		return strategy.executeAlgorithm(a, b);
	}
}
