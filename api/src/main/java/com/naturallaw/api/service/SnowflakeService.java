package com.naturallaw.api.service;

/**
 * description 雪花算法
 *
 * @author Andy
 * @version 1.0
 * @date 06/28/2021 00:01
 */
public interface SnowflakeService {
	/**
	 * @param key key
	 * @return id
	 */
	long getId(String key);

	/**
	 * @param key key
	 * @param num 需要id的个数
	 * @return ids
	 */
	long[] getIds(String key, int num);
}
