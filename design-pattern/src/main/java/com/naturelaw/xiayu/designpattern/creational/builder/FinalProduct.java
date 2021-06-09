package com.naturelaw.xiayu.designpattern.creational.builder;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/20 9:35
 */
public class FinalProduct {
	private PartA partA;
	private PartB partB;

	public PartA getPartA() {
		return partA;
	}

	public void setPartA(PartA partA) {
		this.partA = partA;
	}

	public PartB getPartB() {
		return partB;
	}

	public void setPartB(PartB partB) {
		this.partB = partB;
	}
}
