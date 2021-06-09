package com.naturelaw.xiayu.designpattern.structural.decorator;

/**
 * description: 装饰模式是为了都现有类不做修改的情况下， 扩展现有类的功能及结构。 可以使用嵌套的方式对现有的内容进行包装。
 *
 * @author Administrator
 * @date 2021/6/4 10:55
 */
public class Client {
	public static void main(String[] args) {
		Component existComponent = new ExistedConcreteComponent();
		Component componentWrapper = new ExistedComponentWrapper(existComponent);
		ExistedAWrapper existedAWrapper = new ExistedAWrapper(componentWrapper);
		existedAWrapper.doAction();
	}
}
