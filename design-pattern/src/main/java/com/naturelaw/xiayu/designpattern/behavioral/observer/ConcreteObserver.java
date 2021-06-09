package com.naturelaw.xiayu.designpattern.behavioral.observer;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 17:50
 */
public class ConcreteObserver implements Observer {

	@Override
	public void doAction(Subject subject) {
		System.out.println("观察者收到状态为：" + subject.getStatus());
	}
}
