package com.naturelaw.xiayu.designpattern.behavioral.observer;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 17:41
 */
public abstract class Subject {
	private String status = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	abstract void attach(Observer observer);

	abstract void detach(Observer observer);

	abstract void notifyObservers();
}
