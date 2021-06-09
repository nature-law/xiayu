package com.naturelaw.xiayu.designpattern.creational.builder;

/**
 * description: 建造者模式， 目的是为了解决多个对象组成的复杂对象构建的问题， 将各个对象单独封装， 易于扩展和避免遗漏， 将对象的建造过程封装在方法里，
 * 减少问题的发生。
 * <p>
 * 在建造者模式中  客户端负责的是创建一个 指挥者， 一个工人，
 * 指挥者负责指挥工人， 可以指挥工人创建任意个组件， 可以是完整的， 也可以是不完整的， 根据具体的需要创建不同的产品
 * 工人（Builder） 负责组装产品的每个部分， 并返回最终的产品；
 *
 * @author Administrator
 * @date 2021/5/20 10:54
 */
public class Client {
	public static void main(String[] args) {
		// 指挥者
		Director<FinalProduct> director = new Director<>();
		// 工人
		Builder<FinalProduct> finalProductBuilder = new FinalProductBuilder();
		// 派遣工人，并指挥工人建造
		director.directBuilder(finalProductBuilder);

		// 工人完工 拿出产品
		FinalProduct product = finalProductBuilder.getProduct();

		System.out.println(product.getPartA().getNum());
		System.out.println(product.getPartB().getName());
	}
}
