package com.naturelaw.xiayu.designpattern.behavioral.state;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/21 11:18
 */
public class Context {
	private State state;

	public Context(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void doAction() {
		state.doHandler(this);
	}
}
