package com.naturelaw.xiayu.designpattern.behavioral.vistor;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/24 13:27
 */
public class Woman extends Person {
	private String name = "女人";

	public String getName() {
		return name;
	}

	@Override
	public void acceptAction(Action action) {
		action.doWomanAction(this);
	}
}
