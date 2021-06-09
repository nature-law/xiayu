package com.naturelaw.xiayu.designpattern.behavioral.responsebility;

/**
 * description: 责任链模式需要严格的层级关系，需要每个责任节点清楚的知道下一个节点需要做什么， 通常用来做过滤和验证。
 *
 * @author Administrator
 * @date 2021/5/31 9:30
 */
public class Client {
	public static void main(String[] args) {
		Handler handlerA = new ConcreteHandlerA();
		Handler handlerB = new ConcreteHandlerB();
		Handler handlerC = new ConcreteHandlerC();

		handlerA.setNext(handlerB);
		handlerB.setNext(handlerC);
		handlerA.handler();
	}
}
