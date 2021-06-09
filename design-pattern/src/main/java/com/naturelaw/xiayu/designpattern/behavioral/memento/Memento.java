package com.naturelaw.xiayu.designpattern.behavioral.memento;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 16:56
 */
public class Memento {
	private String name;
	private int age;
	private char status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
}
