package com.naturelaw.sysutils.utils;

import com.naturelaw.sysutils.http.RetrofitClient;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/7/13 10:27
 */
public class IdUtils {

	private static final String ID_GEN_BASE_URL = "http://8.142.78.63:10005";
	private static final String PATH = "/api/snowflake/get/leaf-segment-id";

	public static long genId() {
		RetrofitClient client = RetrofitClient.getInstance();
		Retrofit retrofit = client.getRetrofit(ID_GEN_BASE_URL);
		IdService idService = retrofit.create(IdService.class);
		long id = idService.get();
		return id;
	}

	private interface IdService {
		@GET(PATH)
		long get();
	}
}
