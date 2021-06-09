package com.naturelaw.xiayu.designpattern.behavioral.memento;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 16:55
 */
public class Originator {
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

	/**
	 * Method Description: Created by whx
	 * 〈恢复所有状态〉
	 *
	 * @param memento 备份
	 */
	public void setMemento(Memento memento) {
		this.name = memento.getName();
		this.age = memento.getAge();
		this.status = memento.getStatus();
	}

	public Memento createMemento() {
		Memento memento = new Memento();
		memento.setAge(this.age);
		memento.setName(this.name);
		memento.setStatus(this.status);
		return memento;
	}

}
