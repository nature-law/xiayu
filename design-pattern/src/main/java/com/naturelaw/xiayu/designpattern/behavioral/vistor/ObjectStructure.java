package com.naturelaw.xiayu.designpattern.behavioral.vistor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/24 13:27
 */
public class ObjectStructure {
	private List<Person> personList = new ArrayList<>();

	public void acceptPerson(Person person) {
		this.personList.add(person);
	}

	public void removePerson(Person person) {
		this.personList.remove(person);
	}

	public void doAction(Action action) {
		Iterator<Person> iterator = personList.iterator();
		while (iterator.hasNext()) {
			iterator.next().acceptAction(action);
		}
	}
}
