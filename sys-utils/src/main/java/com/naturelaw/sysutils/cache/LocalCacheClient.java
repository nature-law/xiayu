package com.naturelaw.sysutils.cache;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * description: 本地缓存
 *
 * @author Administrator
 * @date 2021/7/9 17:03
 */
public class LocalCacheClient {
	private static volatile LocalCacheClient client = null;

	private static final int DEFAULT_INIT_SIZE = 100;
	private static final int DEFAULT_MAX_SIZE = 200;

	private static final int DEFAULT_EXPIRE_TIME = 5 * 60;

	private static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;

	private static final com.github.benmanes.caffeine.cache.Cache<String, Object> DEFAULT_CACHE = Caffeine.newBuilder()
			.initialCapacity(DEFAULT_INIT_SIZE)
			.maximumSize(DEFAULT_MAX_SIZE)
			.expireAfterWrite(DEFAULT_EXPIRE_TIME, DEFAULT_TIMEUNIT)
			.build();


	private LocalCacheClient() {
	}

	public static LocalCacheClient getInstance() {
		if (client == null) {
			synchronized (LocalCacheClient.class) {
				if (client == null) {
					client = new LocalCacheClient();
				}
			}
		}
		return client;
	}


	public com.github.benmanes.caffeine.cache.Cache getCache() {
		return DEFAULT_CACHE;
	}

}
