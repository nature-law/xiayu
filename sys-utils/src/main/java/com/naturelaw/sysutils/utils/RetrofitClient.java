package com.naturelaw.sysutils.utils;

import com.naturelaw.sysutils.interceptor.BaseInterceptor;
import com.naturelaw.sysutils.mgt.CookieManager;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

import javax.naming.Context;
import java.util.concurrent.TimeUnit;

/**
 * description: RetrofitClient主要负责创建具体Retrofit，和调度分发请求。设置格式工厂。添加cookie同步，构建OkHttpClient，
 * 添加BaseUrl,对加密证书https我没做加入
 *
 * @author Andy
 * @version 1.0
 * @date 07/08/2021 00:03
 */
public class RetrofitClient {
	private static final int DEFAULT_TIMEOUT = 5;
	private ApiService apiService;
	private OkHttpClient okHttpClient;
	public static String baseUrl = ApiService.Base_URL;
	private static Context mContext;
	private static RetrofitClient sNewInstance;

	private static class SingletonHolder {
		private static RetrofitClient INSTANCE = new RetrofitClient(
				mContext);
	}

	public static RetrofitClient getInstance(Context context) {
		if (context != null) {
			Log.v("RetrofitClient", DevUtil.isDebug() + "");
			mContext = context;
		}
		return SingletonHolder.INSTANCE;
	}


	public static RetrofitClient getInstance(Context context, String url) {
		if (context != null) {
			mContext = context;
		}
		sNewInstance = new RetrofitClient(context, url);
		return sNewInstance;
	}

	private RetrofitClient(Context context) {

		this(context, null);
	}

	private RetrofitClient(Context context, String url) {

		if (TextUtils.isEmpty(url)) {
			url = baseUrl;
		}
		okHttpClient = new OkHttpClient.Builder()
				.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
				.cookieJar(new CookieManager(context))
				.addInterceptor(new BaseInterceptor(mContext))
				.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
				.build();
		Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(url)
				.build();
		apiService = retrofit.create(ApiService.class);
	}

	public void getData(Subscriber<ResponseBody> subscriber, String ip) {
		apiService.getData(ip)
				.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(subscriber);
	}

	public void get(String url, Map headers, Map parameters, Subscriber<ResponseBody> subscriber) {
		apiService.executeGet(url, headers, parameters)
				.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(subscriber);
	}

	public void post(String url, Map headers, Map parameters, Subscriber<ResponseBody> subscriber) {
		apiService.executePost(url, headers, parameters)

				.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(subscriber);
	}
}
