package com.naturelaw.xiayu.designpattern.structural.adapter;

/**
 * description
 *
 * @author Administrator
 * @date 2021/6/1 9:43
 */
public class Adapter extends Target {

	private final AdapteeSpecific adapteeSpecific = new AdapteeSpecific();

	@Override
	public void doAction() {
		adapteeSpecific.specificAction();
	}
}
