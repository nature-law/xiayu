package com.naturelaw.xiayu.designpattern.behavioral.mediator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/27 13:24
 */
public abstract class Colleague {
	public abstract void receiveMessage(String message);

	public abstract void sendMessage(String message);
}
