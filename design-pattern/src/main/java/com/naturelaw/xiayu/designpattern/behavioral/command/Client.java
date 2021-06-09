package com.naturelaw.xiayu.designpattern.behavioral.command;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/26 18:31
 */
public class Client {
	public static void main(String[] args) {
		Receiver receiver = new ConcreteReceiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.execute();

	}
}

