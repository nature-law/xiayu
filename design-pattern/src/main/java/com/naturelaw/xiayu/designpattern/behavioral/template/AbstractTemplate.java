package com.naturelaw.xiayu.designpattern.behavioral.template;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/20 13:07
 */
public abstract class AbstractTemplate {

	protected abstract void doFirst();

	protected abstract void doNext();

	protected abstract void doLast();

	public void doAction() {
		doFirst();
		doNext();
		doLast();
	}
}
