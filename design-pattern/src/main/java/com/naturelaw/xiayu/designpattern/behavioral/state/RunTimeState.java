package com.naturelaw.xiayu.designpattern.behavioral.state;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/21 11:17
 */
public class RunTimeState extends State {
	@Override
	public void doHandler(Context context) {
		System.out.println("运行时状态");
	}
}
