package com.naturelaw.xiayu.designpattern.behavioral.responsebility;

/**
 * description
 *
 * @author Administrator
 * @date 2021/5/31 9:27
 */
public abstract class Handler {

	protected Handler nextHandler;

	public void setNext(Handler handler) {
		this.nextHandler = handler;
	}

	public abstract void handler();

}
