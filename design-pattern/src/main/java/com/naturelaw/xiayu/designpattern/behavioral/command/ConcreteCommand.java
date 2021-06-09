package com.naturelaw.xiayu.designpattern.behavioral.command;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/26 18:24
 */
public class ConcreteCommand extends Command {

	private Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void doAction() {
		receiver.doAction();
	}
}
