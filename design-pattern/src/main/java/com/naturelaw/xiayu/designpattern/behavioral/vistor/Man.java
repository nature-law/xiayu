package com.naturelaw.xiayu.designpattern.behavioral.vistor;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/24 13:27
 */
public class Man extends Person {

	private String name = "男人";

	public String getName() {
		return name;
	}

	@Override
	public void acceptAction(Action action) {
		action.doManAction(this);
	}
}
