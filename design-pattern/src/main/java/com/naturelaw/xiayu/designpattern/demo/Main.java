package com.naturelaw.xiayu.designpattern.demo;

/**
 * description:
 *
 * @author Andy
 * @version 1.0
 * @date 08/28/2021 22:53
 */
public class Main {
	public static void main(String[] args) {
		Tire tire = new Tire();

		Bus bus = new Bus();
		Car car = new Car();

		car.tire = tire;
		car = null;

		System.out.println(car);

		tire.check();
		bus.tire = tire;

	}
}
