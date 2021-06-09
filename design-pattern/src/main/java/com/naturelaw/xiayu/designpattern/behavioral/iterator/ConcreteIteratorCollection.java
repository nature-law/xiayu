package com.naturelaw.xiayu.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 18:39
 */
public class ConcreteIteratorCollection<T> implements IteratorCollection {
	private List<T> list = new ArrayList<>();

	public void attach(T t) {
		list.add(t);
	}

	@Override
	public Iterator iterator() {
		for (int i = 0; i < list.size(); i++) {
			Iterator iterator = new ConcreteIterator();
		}
		return null;
	}
}
