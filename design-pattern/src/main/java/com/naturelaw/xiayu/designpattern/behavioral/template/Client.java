package com.naturelaw.xiayu.designpattern.behavioral.template;

/**
 * description: 模板方法模式解决的是 对于同一种流程的问题， 每一步流程有不同操作的行为， 用统一的一个方法规范化， 用多态的方式具体实现没一步
 * 就不会产生更多if else 从而达到解耦的目的
 *
 * @author Administrator
 * @date 2021/5/20 13:13
 */
public class Client {
	public static void main(String[] args) {
		AbstractTemplate abstractTemplateA = new ConcreteA();
		AbstractTemplate abstractTemplateB = new ConcreteB();
		abstractTemplateA.doAction();
		abstractTemplateB.doAction();
	}
}
