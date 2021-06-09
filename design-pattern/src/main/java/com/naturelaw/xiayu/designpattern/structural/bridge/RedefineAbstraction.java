package com.naturelaw.xiayu.designpattern.structural.bridge;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/2 9:33
 */
public class RedefineAbstraction extends Abstraction {

	@Override
	public void execute() {
		implementor.doAction();
	}
}
