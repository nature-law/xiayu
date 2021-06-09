package com.naturelaw.xiayu.designpattern.behavioral.state;

/**
 * description: 客户端只关心对上下文的创建，而上下文中包含具体的状态， 根据上下文执行操作时， 设置下一个状态， 在下一次调用执行操作时，
 * 重复类似的操作， 所以需要在具体的状态执行操作中接受 执行上下文， 并对设置下一个状态；当客户端再次对执行上下文进行调用的时候， 就自动执行了
 * 对应状态的操作， 实际上就是 执行上下文中存入了具体的状态， 当执行时利用多态的机制， 不用做具体的if else 判断， 、
 * 其中重点是： 上下文中保存状态， 状态中可以得知下一状态是什么
 *
 * @author Administrator
 * @date 2021/5/21 13:15
 */
public class Client {
	public static void main(String[] args) {
		Context context = new Context(new BuildState());
		context.doAction();
		context.doAction();
	}
}
