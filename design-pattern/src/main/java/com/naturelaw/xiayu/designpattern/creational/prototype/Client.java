package com.naturelaw.xiayu.designpattern.creational.prototype;

/**
 * description: 可以在运行时动态快速的创建一个对象。
 *
 * @author Administrator
 * @date 2021/5/19 11:32
 */
public class Client {
	public static void main(String[] args) {
		Prototype prototype = new Prototype();
		prototype.setAge("18");
		prototype.setName("王浩鑫");
		Prototype clone = null;
		try {
			clone = prototype.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(clone.getAge());
		clone.setAge("20");
		System.out.println(prototype.getAge());
	}
}
