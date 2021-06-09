package com.naturelaw.xiayu.designpattern.behavioral.strategy;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/21 10:51
 */
public class Client {
	public static void main(String[] args) {
		Strategy add = new AddOpt();
		Context context = new Context(add);
		System.out.println(context.doAlgorithm(1, 2));
		Strategy muiltOpt = new MuiltOpt();
		Context muiltContext = new Context(muiltOpt);
		System.out.println(muiltContext.doAlgorithm(1, 2));
	}
}
