package com.naturelaw.xiayu.designpattern.behavioral.vistor;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/24 13:28
 */
public class IdeaAction extends Action {
	@Override
	public void doManAction(Person person) {
		System.out.println(((Man) person).getName() + " :我是 逻辑思维！");
	}

	@Override
	public void doWomanAction(Person person) {
		System.out.println(((Woman)person).getName() + " :我管你什么思维！");
	}
}
