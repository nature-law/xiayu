package com.naturelaw.sysutils.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description: 网络访问
 *
 * @author Andy
 * @version 1.0
 * @date 07/06/2021 23:51
 */
public class HttpUtils {

	public static final String BASE_URL = "http://ip.taobao.com/";

	private HttpUtils() {
	}



	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.github.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

	GitHubService service = retrofit.create(GitHubService.class);
}
