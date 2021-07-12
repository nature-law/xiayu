package com.naturelaw.sysutils.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

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

	/**
	 * 设置最大容量为 100M
	 */
	private static final long MAXIMUM_WEIGHT = 1024 * 1024 * 1024 * 100L;

	private static final int MAX_EXPIRE_TIME = 1;

	/**
	 * 默认的过期策略：根据时间过期
	 */
	private static final com.github.benmanes.caffeine.cache.Cache<String, Object> DEFAULT_CACHE = Caffeine.newBuilder()
			.initialCapacity(DEFAULT_INIT_SIZE)
			.maximumSize(DEFAULT_MAX_SIZE)
			.expireAfterWrite(DEFAULT_EXPIRE_TIME, DEFAULT_TIMEUNIT)
			.build();

	/**
	 * 过期策略：根据缓存的权重来进行驱逐（权重只是用于确定缓存大小，不会用于决定该缓存是否被驱逐）
	 */
	private static final LoadingCache<String, Object> WEIGHT_CACHE = Caffeine.newBuilder()
			.maximumWeight(MAXIMUM_WEIGHT)
			.expireAfterAccess(MAX_EXPIRE_TIME, TimeUnit.DAYS)
			.weigher((String key, Object value) -> key.getBytes().length + value.getBytes().length)
			.build(key -> key);

	/**
	 * 过期策略：根据引用进行权重驱逐
	 */
	private static final LoadingCache<String, Object> REF_CACHE = Caffeine.newBuilder()
			.weakKeys()
			.weakValues()
			.expireAfterAccess(MAX_EXPIRE_TIME, TimeUnit.DAYS)
			.build(key -> key);


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


	public com.github.benmanes.caffeine.cache.Cache getDefaultCache() {
		return DEFAULT_CACHE;
	}

	public LoadingCache<String, String> getWeightLoadingCache() {
		return WEIGHT_CACHE;
	}

	public LoadingCache<String, Object> getRefLoadingCache() {
		return REF_CACHE;
	}
}
