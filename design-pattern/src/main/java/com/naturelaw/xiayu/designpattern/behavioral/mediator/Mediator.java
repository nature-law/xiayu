package com.naturelaw.xiayu.designpattern.behavioral.mediator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/27 13:23
 */
public class Mediator {
	Colleague colleagueA;

	Colleague colleagueB;

	public void recognizeColleague(Colleague colleague) {
		if (colleague instanceof ConcreteColleagueA) {
			colleagueA = colleague;
		} else {
			colleagueB = colleague;
		}
	}

	public void sendMessage(Colleague colleague, String message) {
		if (colleague instanceof ConcreteColleagueA) {
			colleagueB.receiveMessage(message);
		} else {
			colleagueA.receiveMessage(message);
		}
	}

}
