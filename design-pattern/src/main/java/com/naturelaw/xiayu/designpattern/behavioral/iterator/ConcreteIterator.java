package com.naturelaw.xiayu.designpattern.behavioral.iterator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/25 18:39
 */
public class ConcreteIterator implements Iterator {

	private Iterator next;

	public void setNext(Iterator next) {
		this.next = next;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Iterator getNext() {
		return null;
	}
}
