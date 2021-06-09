package com.naturelaw.xiayu.designpattern.structural.composite;

import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/2 13:33
 */
public class CoreDepartment extends Component {
	private List<Component> componentList = new LinkedList<>();

	@Override
	public void add(Component component) {
		componentList.add(component);
	}

	@Override
	public void remove(Component component) {
		componentList.remove(component);
	}

	@Override
	public void doAction() {
		System.out.println("领域模型");
	}
}
