package com.naturelaw.xiayu.designpattern.behavioral.command;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/26 18:34
 */
public class ConcreteReceiver extends Receiver {
	@Override
	public void doAction() {
		System.out.println("收到命令");
	}
}
