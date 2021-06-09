package com.naturelaw.xiayu.designpattern.structural.decorator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 10:52
 */
public class ExistedAWrapper extends ExistedComponentWrapper {

	public ExistedAWrapper(Component component) {
		super(component);
	}

	@Override
	public void doAction() {
		System.out.print("++");
		component.doAction();
		System.out.print("++");
	}
}
