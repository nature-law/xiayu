package com.naturelaw.sysutils.utils;

import com.naturelaw.sysutils.cache.LocalCacheClient;

import java.util.concurrent.TimeUnit;

/**
 * description: 本地缓存
 *
 * @author Administrator
 * @date 2021/7/9 15:57
 */
public class LocalCacheUtils<T> {


	public void set(String key, T value) {
		com.github.benmanes.caffeine.cache.Cache cache = LocalCacheClient.getInstance().getCache();
		cache.put(key, value);
	}

	public T get(String key) {

	}
}
