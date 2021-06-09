package com.naturelaw.xiayu.designpattern.structural.facade;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 13:34
 */
public class Facade {
	private SystemA systemA;
	private SystemB systemB;
	private SystemC systemC;

	public void init() {
		systemA = new SystemA();
		systemB = new SystemB();
		systemC = new SystemC();
	}

	public void invokeA() {
		try {
			systemA.doActionA();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public void invokeB() throws NoSuchMethodException {
		systemB.doActionB();
	}

	public void invokeABC() throws NoSuchMethodException {
		systemA.doActionA();
		systemB.doActionB();
		systemC.doActionC();
	}
}
