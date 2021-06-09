package com.naturelaw.xiayu.designpattern.structural.composite;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/2 13:29
 */
public class CloudHubCompany extends Component {
	@Override
	public void add(Component component) {
		// do nothing
	}

	@Override
	public void remove(Component component) {
		// do nothing
	}

	@Override
	public void doAction() {
		System.out.println("这里是云之家");
	}
}
