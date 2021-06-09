package com.naturelaw.xiayu.designpattern.behavioral.mediator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/27 13:27
 */
public class ConcreteColleagueB extends Colleague {
	private Mediator mediator;

	public ConcreteColleagueB(Mediator mediator) {
		this.mediator = mediator;
	}


	@Override
	public void receiveMessage(String message) {
		System.out.println("我是B, 我收到了：" + message);
	}

	@Override
	public void sendMessage(String message) {
		mediator.sendMessage(this, message);
	}
}
