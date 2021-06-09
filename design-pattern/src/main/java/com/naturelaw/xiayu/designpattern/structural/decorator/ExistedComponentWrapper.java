package com.naturelaw.xiayu.designpattern.structural.decorator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 10:32
 */
public class ExistedComponentWrapper extends Component {
	protected Component component;

	public ExistedComponentWrapper(Component component) {
		this.component = component;
	}

	@Override
	public void doAction() {
		System.out.print("-->");
		component.doAction();
		System.out.print("<--");
	}
}
