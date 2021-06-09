package com.naturelaw.xiayu.designpattern.structural.decorator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 10:31
 */
public class ExistedConcreteComponent extends Component {
	@Override
	public void doAction() {
		System.out.println("已经存在的类");
	}
}
