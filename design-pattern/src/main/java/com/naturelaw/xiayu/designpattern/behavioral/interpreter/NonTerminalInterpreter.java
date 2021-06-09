package com.naturelaw.xiayu.designpattern.behavioral.interpreter;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/31 18:25
 */
public class NonTerminalInterpreter implements Interpreter {

	@Override
	public int interpreter(Context context) {
		System.out.println("非终端解释器！");
		return 0;
	}
}
