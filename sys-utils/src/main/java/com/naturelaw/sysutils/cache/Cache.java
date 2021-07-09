package com.naturelaw.sysutils.cache;

import java.util.concurrent.TimeUnit;

/**
 * description 缓存
 *
 * @author Administrator
 * @date 2021/7/9 15:54
 */
public interface Cache<T> {
	/**
	 * description：放入缓存
	 *
	 * @param key   键
	 * @param value 值
	 */
	void set(String key, T value);

	/**
	 * @param key        键
	 * @param value      值
	 * @param expireTime 过期时间
	 */
	void set(String key, T value, int expireTime);

	/**
	 * @param key
	 * @param value
	 * @param expireTime
	 * @param timeUnit
	 */
	void set(String key, T value, int expireTime, TimeUnit timeUnit);

	/**
	 * description：获取值
	 *
	 * @param key 键
	 */

	T get(String key);


}
