package com.naturelaw.xiayu.designpattern.behavioral.observer;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 17:59
 */
public class Client {
	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();

		subject.setStatus("成功");

		Observer observer1 = new OtherObserver();
		Observer observer2 = new OtherObserver();
		Observer observer3 = new ConcreteObserver();
		Observer observer4 = new ConcreteObserver();

		subject.attach(observer1);
		subject.attach(observer2);
		subject.attach(observer3);
		subject.attach(observer4);
		subject.notifyObservers();

	}
}
