package com.naturelaw.xiayu.designpattern.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 17:46
 */
public class ConcreteSubject extends Subject {

	private final List<Observer> observerList = new LinkedList<>();

	@Override
	public void attach(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		observerList.forEach(observer -> {
			observer.doAction(this);
		});
	}
}
