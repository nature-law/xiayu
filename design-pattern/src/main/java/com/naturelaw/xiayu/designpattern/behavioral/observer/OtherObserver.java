package com.naturelaw.xiayu.designpattern.behavioral.observer;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 17:51
 */
public class OtherObserver implements Observer {
	@Override
	public void doAction(Subject subject) {
		System.out.println("毫不相干的类收到：" + subject.getStatus());
	}
}
