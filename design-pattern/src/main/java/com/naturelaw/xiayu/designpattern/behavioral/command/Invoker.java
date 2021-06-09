package com.naturelaw.xiayu.designpattern.behavioral.command;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/26 18:24
 */
public class Invoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
		command.doAction();
	}
}
