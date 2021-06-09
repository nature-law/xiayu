package com.naturelaw.xiayu.designpattern.creational.builder;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/5/20 10:39
 */
public class FinalProductBuilder extends Builder<FinalProduct> {

	private final FinalProduct finalProduct = new FinalProduct();

	@Override
	protected void buildPartA() {
		PartA partA = new PartA();
		partA.setNum("007");
		finalProduct.setPartA(partA);
	}

	@Override
	protected void buildPartB() {
		PartB partB = new PartB();
		partB.setName("Andy");
		finalProduct.setPartB(partB);
	}

	@Override
	public FinalProduct getProduct() {
		return finalProduct;
	}
}
