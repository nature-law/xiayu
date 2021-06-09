package com.naturelaw.xiayu.designpattern.behavioral.vistor;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/24 13:48
 */
public class Client {
	public static void main(String[] args) {
		Action action = new IdeaAction();
		Person man = new Man();
		Person woman = new Woman();

		ObjectStructure objectStructure = new ObjectStructure();
		objectStructure.acceptPerson(woman);
		objectStructure.acceptPerson(man);
		objectStructure.doAction(action);

	}
}
