package com.naturelaw.xiayu.designpattern.behavioral.memento;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 16:56
 */
public class CareTaker {

	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
