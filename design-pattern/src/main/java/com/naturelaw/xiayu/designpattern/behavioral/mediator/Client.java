package com.naturelaw.xiayu.designpattern.behavioral.mediator;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/27 13:49
 */
public class Client {
	public static void main(String[] args) {
		Mediator mediator = new Mediator();
		Colleague colleagueA = new ConcreteColleagueA(mediator);
		Colleague colleagueB = new ConcreteColleagueB(mediator);
		mediator.recognizeColleague(colleagueA);
		mediator.recognizeColleague(colleagueB);

		colleagueA.sendMessage("你好， 我是A");
		colleagueB.sendMessage("我是B， 收到就好");
	}
}
