package com.naturelaw.xiayu.designpattern.behavioral.mediator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/27 13:26
 */
public class ConcreteColleagueA extends Colleague {

	private Mediator mediator;

	public ConcreteColleagueA(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void sendMessage(String message) {
		mediator.sendMessage(this, message);
	}
}
