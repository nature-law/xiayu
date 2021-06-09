package com.naturelaw.xiayu.designpattern.structural.facade;

/**
 * description:
 * 1、在设计初期，要有意识的将不同的两个层分离，层与层之间的调用处理就可以使用外观模式降低耦合。例如经典的mvc架构。
 * 2、在开发阶段，子系统往往因为不断地重构演化而变得越来越复杂，大多数的模式使用时也都会产生很多很小的类，增加外观可以提供一个简单的接口，减少它们之间的依赖。
 * 3、在维护一个遗留的大型系统时，可以为新系统开发一个外观类，来提供设计粗糙或高度复杂的遗留代码的比较清晰简单的接口，让新系统与外观对象交互，外观与遗留代码交互所有复杂的工作。
 *
 * @author Administrator
 * @date 2021/6/4 13:42
 */
public class Client {
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.init();
		facade.invokeA();
		try {
			facade.invokeB();
			facade.invokeABC();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
