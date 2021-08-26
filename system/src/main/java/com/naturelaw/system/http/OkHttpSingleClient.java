package com.naturelaw.system.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * description: RetrofitClient主要负责创建具体Retrofit，和调度分发请求。设置格式工厂。添加cookie同步，构建OkHttpClient，
 * 添加BaseUrl
 *
 * @author Andy
 * @version 1.0
 * @date 07/08/2021 00:03
 */
public class OkHttpSingleClient {
	private volatile static OkHttpSingleClient client = null;

	private static final int DEFAULT_CONNECT_TIME = 10;
	private static final int DEFAULT_WRITE_TIME = 30;
	private static final int DEFAULT_READ_TIME = 30;

	private static final Cache<String, OkHttpClient> CACHE = Caffeine.newBuilder()
			.initialCapacity(20)
			.maximumSize(100)
			.expireAfterWrite(5, TimeUnit.MINUTES)
			.build();

	private OkHttpSingleClient() {
	}

	public static OkHttpSingleClient getInstance() {
		if (client == null) {
			synchronized (OkHttpSingleClient.class) {
				if (client == null) {
					client = new OkHttpSingleClient();
				}
			}
		}
		return client;
	}

	public String get(@NotNull String url) throws IOException {
		return get(url, String.class);
	}

	public <T> T get(@NotNull String url, Class<T> clazz) throws IOException {
		OkHttpClient client = CACHE.get(url, key -> null);
		if (client == null) {
			client = new OkHttpClient.Builder()
					//连接超时时间
					.connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)
					//设置写操作超时时间
					.writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)
					//设置读操作超时时间
					.readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)
					.build();
			CACHE.put(url, client);
		}
		Request request = new Request.Builder()
				.url(url)
				.build();

		T t = null;
		try (Response response = client.newCall(request).execute()) {
			ResponseBody body = response.body();
			if (body != null) {
				String result = body.string();
				ObjectMapper objectMapper = new ObjectMapper();
				t = objectMapper.readValue(result, clazz);
			}
		}
		return t;
	}
}
