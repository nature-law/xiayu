package com.naturelaw.sysutils.http;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

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

	private static final int DEFAULT_CONNECT_TIME = 10;
	private static final int DEFAULT_WRITE_TIME = 30;
	private static final int DEFAULT_READ_TIME = 30;

	private static final Cache<String, Retrofit> CACHE = Caffeine.newBuilder()
			.initialCapacity(20)
			.maximumSize(50)
			.expireAfterWrite(5, TimeUnit.MINUTES)
			.build();

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


	public Retrofit getRetrofit(String baseUrl) {
		Retrofit retrofit = CACHE.get(baseUrl, key -> null);
		if (retrofit == null) {
			OkHttpClient okHttpClient = new OkHttpClient.Builder()
					.connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)//连接超时时间
					.writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)//设置写操作超时时间
					.readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)//设置读操作超时时间
					.build();
			retrofit = new Retrofit.Builder()
					.baseUrl(baseUrl)
					.client(okHttpClient)
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.build();
			CACHE.put(baseUrl, retrofit);
		}
		return retrofit;
	}
}
