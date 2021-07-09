package com.naturelaw.sysutils.mgt;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.List;

/**
 * description:构建Cookie管理者,用来管理cookie, 储存cookie的store
 *
 * @author Andy
 * @version 1.0
 * @date 07/08/2021 00:01
 */
public class CookieManager implements CookieJar {

	@Override
	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

	}

	@Override
	public List<Cookie> loadForRequest(HttpUrl url) {
		return null;
	}
}
