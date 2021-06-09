package com.naturelaw.xiayu.designpattern.creational.singleton;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/19 12:33
 */
public class Singleton {
	private static volatile Singleton instance = null;

	private String name;

	private Singleton() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void sayName() {
		System.out.println("hello：" + name);
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
