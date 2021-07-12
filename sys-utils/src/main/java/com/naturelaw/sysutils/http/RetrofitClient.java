package com.naturelaw.sysutils.http;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.naturelaw.sysutils.cache.LocalCacheClient;
import com.sun.istack.internal.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description: RetrofitClient主要负责创建具体Retrofit，和调度分发请求。设置格式工厂。添加cookie同步，构建OkHttpClient，
 * 添加BaseUrl
 *
 * @author Andy
 * @version 1.0
 * @date 07/08/2021 00:03
 */
public class RetrofitClient {
	private volatile static RetrofitClient client = null;

	private RetrofitClient() {
	}

	public static RetrofitClient getInstance() {
		if (client == null) {
			synchronized (RetrofitClient.class) {
				if (client == null) {
					client = new RetrofitClient();
				}
			}
		}
		return client;
	}

	public static Retrofit getRetrofit(@NotNull String baseUrl) {
		LoadingCache<String, Object> weightLoadingCache = LocalCacheClient.getInstance().getWeightLoadingCache();
		Retrofit retrofit = (Retrofit) weightLoadingCache.get(baseUrl);
		if (retrofit == null) {
			retrofit = new Retrofit.Builder()
					.baseUrl(baseUrl)
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			weightLoadingCache.put(baseUrl, retrofit);
		}
		return retrofit;
	}
}
