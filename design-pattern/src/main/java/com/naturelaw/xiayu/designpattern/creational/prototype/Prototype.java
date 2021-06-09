package com.naturelaw.xiayu.designpattern.creational.prototype;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/19 11:31
 */
public class Prototype implements Cloneable {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	protected Prototype clone() throws CloneNotSupportedException {
		return (Prototype) super.clone();
	}
}
