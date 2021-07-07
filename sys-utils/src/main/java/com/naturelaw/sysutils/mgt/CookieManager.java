package com.naturelaw.sysutils.mgt;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import javax.naming.Context;
import java.util.List;

/**
 * description:构建Cookie管理者,用来管理cookie, 储存cookie的store
 *
 * @author Andy
 * @version 1.0
 * @date 07/08/2021 00:01
 */
public class CookieManager implements CookieJar {
	private static final String TAG = "NovateCookieManger";
	private static Context mContext;
	private static PersistentCookieStore cookieStore;
	/**
	 * Mandatory constructor for the NovateCookieManger
	 */
	public CookieManger(Context context) {
		mContext = context;    if (cookieStore == null) {
			cookieStore = new PersistentCookieStore(mContext);
		}
	}
	@Override
	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		if (cookies != null && cookies.size() > 0) {
			for (Cookie item : cookies) {
				cookieStore.add(url, item);
			}
		}
	}
	@Override
	public List<Cookie> loadForRequest(HttpUrl url) {
		List<Cookie> cookies = cookieStore.get(url);
		return cookies;
	}
}
