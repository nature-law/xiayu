package com.naturelaw.xiayu.designpattern.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/6/4 13:48
 */
public class FlyWeightFactory {
	private final Map<String, FlyWeight> flyWeightMap = new ConcurrentHashMap<>();

	public FlyWeight getFlyWeight(String key) {
		FlyWeight flyWeight = flyWeightMap.get(key);
		if (flyWeight == null) {
			synchronized (FlyWeightFactory.class) {
				if (flyWeight == null) {
					flyWeight = new ConcreteFlyWeightA();
					flyWeightMap.put(key, flyWeight);
				}
			}
		}
		return flyWeight;
	}

}
