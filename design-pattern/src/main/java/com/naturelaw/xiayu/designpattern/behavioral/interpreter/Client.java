package com.naturelaw.xiayu.designpattern.behavioral.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * 可以将一个需要解释执行的语言中的句子表示为一个抽象语法树。
 * 一些重复出现的问题可以用一种简单的语言来进行表达。
 * 一个语言的文法较为简单。
 * 对执行效率要求不高。
 *
 * @author Administrator
 * @date 2021/5/31 18:28
 */
public class Client {
	public static void main(String[] args) {
		Context context = new Context();

		List<Interpreter> list = new ArrayList<>();
		list.add(new TerminalInterpreter());
		list.add(new NonTerminalInterpreter());
		list.add(new TerminalInterpreter());
		list.add(new TerminalInterpreter());
		for (Interpreter interpreter : list) {
			interpreter.interpreter(context);
		}
	}
}
